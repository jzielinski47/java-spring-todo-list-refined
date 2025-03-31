# Java Spring Boot ToDo List
I created a simple Java Spring Boot todo list server studying the framework logic with Controllers, Services, etc. I enhanced it by data validation, custom DTOs, and getting started with RESTful API in Java. 

## Server Endpoints

#### Display all tasks
```http
GET /api/v1/tasks
```

#### Display all completed tasks
```http
GET /api/v1/tasks/completed
```

#### Display all incompleted tasks
```http
GET /api/v1/tasks/incompleted
```

#### Display tasks by priority
```http
GET /api/v1/tasks/{priority}
```
Displays all the tasks with given priority.

| Parameter	 | Type | Description |
| -----------| ----| -------- |
| priority |	int |	@Min 0, @Max 5 |

#### Display tasks by priority range
```http
GET /api/v1/tasks/priority
```
Displays all the tasks with given priority range

| Parameter	 | Type | Description                             |
|----------| ----|-----------------------------------------|
| min |	int | 	@RequestParam Optional. @Min 0, @Max 5 |
| max |	int | 	@RequestParam Optional. @Min 0, @Max 5 |

#### Creates a new task
```http
POST /api/v1/tasks
```
Creates a new task

| Parameter	 | Type | Description |
| -----------| ----| -------- |
| name |	String	| @NotBlank Name cannot be empty |
| priority |	int |	Optional. @Min 0, @Max 5, default: 0 |
| completed	|boolean	| Optional. default: false |

#### Update a single task
```http
PATCH /api/v1/tasks/{id}
```
Patches a task with a single field update

| Parameter	 | Type | Description |
| -----------| ----| -------- |
| id |	Long	| Required. @PathVariable |
| name |	String	| Optional. |
| priority |	int |	Optional. @Min 0, @Max 5, default: 0 |
| completed	|boolean	| Optional. default: false |

#### Update an entire task
```http
PUT /api/v1/tasks/{id}
```
Replaces single task with different task

| Parameter	 | Type | Description |
| -----------| ----| -------- |
| id |	Long	| Required. @PathVariable |
| name |	String	| @NotBlank Name cannot be empty |
| priority |	int |	Optional. @Min 0, @Max 5, default: 0 |
| completed	|boolean	| Optional. default: false |

#### Delete a task
```http
DELETE /api/v1/tasks/{id}
```
Replaces single task with different task

| Parameter	 | Type | Description |
| -----------| ----| -------- |
| id |	Long	| Required. @PathVariable |
