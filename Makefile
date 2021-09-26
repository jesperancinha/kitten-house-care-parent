b: build
build: build-npm build-maven
build-npm:
	cd package/kitten-house-care-web && yarn install && npm run build
	cd package/kitten-house-care-mock && yarn install
build-maven:
	mvn clean install -DskipTests
test:
	mvn test
	cd package/kitten-house-care-web && yarn install && npm run test
	cd package/kitten-house-care-mock && yarn install
test-maven:
	mvn test
local: no-test
	mkdir -p bin
no-test:
	mvn clean install -DskipTests
docker-clean:
	docker-compose rm -svf
docker:
	rm -rf out
	docker-compose up -d --build --remove-orphans
stop:
	docker-compose down --remove-orphans
prune-all: stop
	docker ps -a --format '{{.ID}}' -q | xargs docker stop
	docker ps -a --format '{{.ID}}' -q | xargs docker rm
	docker system prune --all
	docker builder prune
	docker system prune --all --volumes
