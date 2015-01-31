package nb.ninja;

import com.bendb.dropwizard.redis.JedisBundle;
import com.bendb.dropwizard.redis.JedisFactory;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nb.ninja.resources.NinjaResource;

public class NinjaApplication extends Application<NinjaConfiguration>{

    private final JedisBundle<NinjaConfiguration> jedisBundle = new JedisBundle<NinjaConfiguration>() {
        @Override
        public JedisFactory getJedisFactory(NinjaConfiguration configuration) {
            return configuration.getJedisFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<NinjaConfiguration> bootstrap) {
        bootstrap.addBundle(jedisBundle);
    }
    @Override
    public void run(NinjaConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new NinjaResource());
    }

    public static void main(String[] args) throws Exception {
        new NinjaApplication().run(args);
    }
}
