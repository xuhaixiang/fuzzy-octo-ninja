package nb.ninja;

import com.bendb.dropwizard.redis.JedisFactory;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class NinjaConfiguration extends Configuration {

    @JsonProperty("redis")
    JedisFactory jedisFactory;

    public JedisFactory getJedisFactory() {
        return jedisFactory;
    }

    public void setJedisFactory(JedisFactory jedisFactory) {
        this.jedisFactory = jedisFactory;
    }
}
