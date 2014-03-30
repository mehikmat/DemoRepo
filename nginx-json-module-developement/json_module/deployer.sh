#!/bin/sh
cd ../nginx-1.4.4 
./configure --add-module=/vagrant/echo-nginx-module --add-module=/vagrant/json_module
make 
sudo make install
sudo cp /vagrant/nginx.conf  /usr/local/nginx/conf/nginx.conf 
sudo /usr/local/nginx/sbin/nginx -s stop
sudo /usr/local/nginx/sbin/nginx
