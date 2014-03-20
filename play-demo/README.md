====Play Demo [Play Hello World]====
====================================
Environment Setup
=================
	[1] PLAY SETUP
	--------------------------------------------
	Download play framework play-2.2.1.zip and unzip it in the /opt or where ever you want
	   $ wget -O play-2.2.1.zip http://downloads.typesafe.com/play/2.2.1/play-2.2.1.zip 
	   $ sudo cp play-2.2.1.zip /opt/
	   $ cd /opt
	   $ sudo yum install unzip
	   $ sudo unzip play-2.2.1.zip

	Configure the PATH
       $ echo export PATH=$PATH:/opt/play-2.2.1 >> $HOME/.bashrc  && bash  


How to run?
============
	$ git clone https://github.com/mehikmat/DemoRepo.git
	$ cd DemoRepo/play-demo
	$ play start
 Browse http://localhost:9000