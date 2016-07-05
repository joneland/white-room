## Build

Create uberjars for app and stub

`cd <project_root>/app ; lein uberjar`

`cd <project_root>/stub; lein uberjar`

## Deploy

`cd <project_root> ; docker-compose up -d`

## Running Tests

### Unit Tests

`cd <project_root>/app ; lein test`

### Behaviour Tests

Note, the app must be deployed for these tests

`cd <project_root>/app ; lein test :behaviour`

### All Tests

Note, again the app must be deployed for the behaviour tests to run

`cd <project_root>/app ; lein test :all`
