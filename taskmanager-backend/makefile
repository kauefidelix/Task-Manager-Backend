# Makefile for Task Manager Backend API

# Variables
JAVA_VERSION=19.0.1
MAVEN_VERSION=3.6.3
CASSANDRA_VERSION=3.11.6

# Targets

# Target to create the Docker instance
docker:
	# Create the Docker instance
	docker build -t taskmanager-backend .
	docker run -d -p 8080:8080 --name taskmanager-backend taskmanager-backend

# Target to install Java and Maven
install:
	# Install Java and Maven
	apt-get update
	apt-get install openjdk-8-jdk maven -y

	# Install Cassandra
	echo "deb http://www.apache.org/dist/cassandra/debian 311x main" | tee -a /etc/apt/sources.list.d/cassandra.sources.list
	apt-get update
	apt-get install cassandra -y

setup:
	# Start Cassandra service
	systemctl start cassandra


	# Create the database tables
	cqlsh -f /path/to/script.cql

run:
	# Build and run the application
	mvn clean install
	java -jar target/taskmanager-backend-0.0.1-SNAPSHOT.jar

# Target to set up the database
db:
	docker exec -d taskmanager-backend cassandra/bin/cassandra

# Target to install spring
spring:
	docker exec taskmanager-backend mvn install

# Target to initiate the application
start:
	docker exec taskmanager-backend mvn spring-boot:run

# Target to cleanup the environment
clean:
	docker stop taskmanager-backend
	docker rm taskmanager-backend
