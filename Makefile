b: build
build: build-maven
build-maven:
	mvn clean install
test: test-maven
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
remove-lock-files:
	find . -name "package-lock.json" | xargs -I {} rm {}; \
	find . -name "yarn.lock" | xargs -I {} rm {};
update: remove-lock-files
	git pull
	npm install caniuse-lite
	npm install -g npm-check-updates
	cd stamps-and-coins-web; \
 		yarn; \
 		npx browserslist --update-db; \
 		ncu -u; \
 		yarn
coverage:
	mvn clean -Preports install jacoco:prepare-agent package jacoco:report
