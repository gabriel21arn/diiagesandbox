# diiagesandbox

This application allows you to consult the various characters from our favorite films and series.

## Functionality

on the home page you can consult all the characters, with a click on our character, additional information can be consulted.

## Functioning

For the moment the application runs alone, it does not call any API, or any other external services. The data is stored raw in the application.

### The data classes to enrich

#### Class diagram

| Character            |
|----------------------|
| - id: Int            |
| - firstName: String  |
| - lastName: String   |
| - age: Int           |
| - presence: List<Episode> |


| Episode          |
|------------------|
| - id: Int        |
| - date: String   |
| - name: String   |

**Character** has a list of **Episode** (`presence`).