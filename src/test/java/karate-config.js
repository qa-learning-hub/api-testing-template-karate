function fn() {
  var env = karate.env;// get system property 'karate.env'
  var publicKey1 = java.lang.System.getenv('publicKey');
  karate.log('karate.env system property was:', publicKey1);
  if (!env) {
    env = 'dev';
  }
  karate.config= {retry: {count: 3, interval: 1000}};
  var config = {
    env: env,
    baseUrl: 'https://reqres.in',
    apikey: { 'x-api-key': 'reqres-free-v1' },
    publicKey: publicKey1,
  }
  if (env == 'dev') {
    // customize
    // e.g. config.foo = 'bar';
    config.baseUrl = 'https://reqres.in';
  } else if (env == 'stage') {
    config.baseUrl = 'https://reqres.in';
  }else if (env == 'prod') {
   config.baseUrl = 'https://reqres.in';
}
  karate.configure('connectTimeout', 5000);
  karate.configure('readTimeout', 5000);
  return config;
}