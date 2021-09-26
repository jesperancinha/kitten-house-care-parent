# kitten-house-care-mock

A mock to support the web development

## Start server

```shell
cd package/kitten-house-care-mock
node server.js
```

## Testing

#### Start server

```shell
node server.js
```

#### Connecting to server

```shell
curl -H Accept:text/event-stream http://localhost:8082/khc/available
```

#### Posting to server

```shell
curl -X POST -H "Content-Type: application/json" -d '{"info": "Cat1"}' -s http://localhost:8082/khc/incoming
curl -X POST -H "Content-Type: application/json" -d '{"info": "Cat2"}' -s http://localhost:8082/khc/incoming
```