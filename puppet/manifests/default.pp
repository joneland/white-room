exec { 'update_packages':
  command => 'apt-get update',
  path    => '/usr/bin',
}

exec { 'get_leiningen':
  command => '/usr/bin/wget https://raw.github.com/technomancy/leiningen/stable/bin/lein -O /usr/bin/lein && /bin/chmod a+x /usr/bin/lein',
}

include java
