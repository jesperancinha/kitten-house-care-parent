const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');

const app = express();

app.use(cors());
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: false}));

app.get('/status', (request, response) => response.json({clients: clientConnections.length}));

const PORT = 8082;

let clientConnections = [];
let kittens = [];

app.listen(PORT, () => {
    console.log(`Facts Events service listening at http://localhost:${PORT}`)
})

function eventsHandler(request, response, next) {
    const headers = {
        'Content-Type': 'text/event-stream',
        'Connection': 'keep-alive',
        'Cache-Control': 'no-cache'
    };
    response.writeHead(200, headers);

    const data = `data: ${JSON.stringify(kittens)}\n\n`;

    response.write(data);

    const clientId = Date.now();

    const newClientConnection = {
        id: clientId,
        response
    };

    clientConnections.push(newClientConnection);

    request.on('close', () => {
        console.log(`${clientId} Connection closed`);
        clientConnections = clientConnections.filter(client => client.id !== clientId);
    });
}


function sendEventsToAll(newCat) {
    clientConnections.forEach(client => client.response.write(`data: ${JSON.stringify(newCat)}\n\n`))
}

async function addKitten(request, response, next) {
    const newCat = request.body;
    kittens.push(newCat);
    response.json(newCat)
    return sendEventsToAll(newCat);
}

app.get('/khc/available', eventsHandler);
app.post('/khc/incoming', addKitten);