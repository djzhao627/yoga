package com.fc.common.redis.shiro;

import java.util.List;
import java.util.Map;

import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
/**
 * @author fengchi
 * @version V1.0
 */

/**
 * Redis操作类
 * 用法：
 *
 * @Autowired private RedisManager redisMgr;
 */
public class RedisManager {

    @Value("${spring.redis.host}")
    private String host = "127.0.0.1";

    @Value("${spring.redis.port}")
    private int port = 6379;

    // 0 - never expire
    private int expire = 0;

    //timeout for jedis try to connect to redis server, not expire time! In milliseconds
    @Value("${spring.redis.timeout}")
    private int timeout = 0;

    @Value("${spring.redis.password}")
    private String password = "";

    //默认db索引
    private int dbIndex = 1;

    private static JedisPool jedisPool = null;

    public RedisManager() {

    }

    /**
     * 初始化方法
     */
    public void init() {
        if (jedisPool == null) {
            if (password != null && !"".equals(password)) {
                jedisPool = new JedisPool(new JedisPoolConfig(), host, port, timeout, password, dbIndex);
            } else if (timeout != 0) {
                jedisPool = new JedisPool(new JedisPoolConfig(), host, port, timeout);
            } else {
                jedisPool = new JedisPool(new JedisPoolConfig(), host, port);
            }

        }
    }

    /**
     * get value from redis
     */
    public byte[] get(byte[] key) {
        byte[] value = null;
        Jedis jedis = jedisPool.getResource();
        try {
            value = jedis.get(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return value;
    }

    /**
     * set
     */
    public byte[] set(byte[] key, byte[] value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(key, value);
            if (this.expire != 0) {
                jedis.expire(key, this.expire);
            }
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return value;
    }

    /**
     * set
     */
    public byte[] set(byte[] key, byte[] value, int expire) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(key, value);
            if (expire != 0) {
                jedis.expire(key, expire);
            }
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return value;
    }

    /**
     * del
     */
    public void del(byte[] key) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.del(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * flush
     */
    public void flushDB() {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.flushDB();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * size
     */
    public Long dbSize() {
        Long dbSize = 0L;
        Jedis jedis = jedisPool.getResource();
        try {
            dbSize = jedis.dbSize();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return dbSize;
    }

    /**
     * keys
     *
     * @param pattern
     * @return
     */
    public Set<byte[]> keys(String pattern) {
        Set<byte[]> keys = null;
        Jedis jedis = jedisPool.getResource();
        try {
            keys = jedis.keys(pattern.getBytes());
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return keys;
    }


    /*新增redis操作 start*/
    public String redisPrefix = "ljf:";

    /**
     * 根据key获取缓存数据
     *
     * @param key
     * @return
     */
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.get(redisPrefix + key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 根据key设置缓存数据，如果以前存在更新，如果以前没有添加
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(redisPrefix + key, value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 根据key设置缓存数据，如果以前存在更新，如果以前没有添加
     *
     * @param key
     * @param value
     * @param expire 过期时间，单位秒
     */
    public void set(String key, String value, int expire) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(redisPrefix + key, value);
            jedis.expire(redisPrefix + key, expire);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 根据key删除缓存数据
     *
     * @param key
     */
    public void del(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.del(redisPrefix + key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 批量删除key，参数key已经包含系统前缀不需要再手工拼接前缀
     *
     * @param keys
     */
    public void delKeysWithoutPrefix(String... keys) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.del(keys);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 设置集合
     *
     * @param key
     * @param value
     */
    public void sadd(String key, String... value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.sadd(redisPrefix + key, value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 获取指定键名的集合中的所有成员
     *
     * @param key
     * @return
     */
    public Set<String> smembers(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.smembers(redisPrefix + key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 返回集合中的随机元素
     *
     * @param key
     * @param count
     * @return
     */
    public List<String> srandmember(String key, int count) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.srandmember(redisPrefix + key, count);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 移除集合
     *
     * @param key
     * @return
     */
    public void spop(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.spop(redisPrefix + key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 移除集合中的一个或多个元素
     *
     * @param key
     * @return
     */
    public void srem(String key, String... value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.srem(redisPrefix + key, value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 添加到SoredSet
     *
     * @param key
     * @param score
     * @param value
     */
    public void zadd(String key, double score, String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.zadd(redisPrefix + key, score, value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 从SortedSet返回指定分数的值
     *
     * @param key
     * @param scoreStart
     * @param scoreEnd
     * @return
     */
    public Set<String> zrangeByScore(String key, double scoreStart, double scoreEnd) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.zrangeByScore(redisPrefix + key, scoreStart, scoreEnd);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 从SortedSet删除指定值
     *
     * @param key
     * @param value
     */
    public void zrem(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.zrem(redisPrefix + key, value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 添加到hash
     *
     * @param key
     * @param field
     * @param value
     */
    public void hset(String key, String field, String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.hset(redisPrefix + key, field, value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * hash字段累加
     *
     * @param key
     * @param field
     */
    public void hincrBy(String key, String field, int value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.hincrBy(redisPrefix + key, field, value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * hash字段浮点数累加
     *
     * @param key
     * @param field
     */
    public void hincrByFloat(String key, String field, double value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.hincrByFloat(redisPrefix + key, field, value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 从hash中读取
     *
     * @param key
     * @param field
     * @return
     */
    public String hget(String key, String field) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.hget(redisPrefix + key, field);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 从hash中删除
     *
     * @param key
     * @param field
     */
    public void hdel(String key, String field) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.hdel(redisPrefix + key, field);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 从hash中读取所有field
     *
     * @param key
     * @return
     */
    public Map<String, String> hgetAll(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.hgetAll(redisPrefix + key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 从hash中读取所有field，参数key已经包含系统前缀不需要再手工拼接前缀
     *
     * @param key
     * @return
     */
    public Map<String, String> hgetAllWithoutPrefix(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.hgetAll(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 设置key的过期时间
     *
     * @param key
     * @param seconds
     */
    public void expire(String key, int seconds) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.expire(redisPrefix + key, seconds);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 检查键是否存在
     *
     * @param key
     * @return
     */
    public Boolean exists(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.exists(redisPrefix + key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 遍历key
     * 用法实例：
     * ScanResult<String> scanResult = redisHelper.scan(cur, keyPrefix + "*");
     * List<String> keyList = new ArrayList<>();
     * scanResult.getResult().forEach(key -> {
     * //Key最后为日期，删除不是当天的Key
     * if (!dateString.equals(key.substring(key.length() - DateHelper.DATE_FORMAT.length(), key.length()))) {
     * logger.debug("StatService deleteExpiredStatRedisKeys key:" + key);
     * keyList.add(key);
     * }
     * });
     * if (keyList.size() > 0) {
     * redisHelper.delKeysWithoutPrefix(keyList.stream().toArray(String[]::new));
     * }
     *
     * @param cursor
     * @param prefix
     * @return
     */
    public ScanResult<String> scan(String cursor, String prefix) {
        ScanParams scanParams = new ScanParams().count(20).match(redisPrefix + prefix);
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.scan(cursor, scanParams);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * HyperLogLog计数
     *
     * @param prefix
     * @param element
     * @return
     */
    public long pfadd(String prefix, String element) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.pfadd(redisPrefix + prefix, element);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 获取HyperLogLog计数数量
     *
     * @param prefix
     * @return
     */
    public long pfcount(String prefix) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.pfcount(redisPrefix + prefix);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    /*新增redis操作 end*/


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
