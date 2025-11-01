
# Blog API Documentation

## Base URL
[http://localhost:8080/api](http://localhost:8080/api)


## Authentication

### Register User
**POST /auth/register**

**Request Body**
```json
{
  "name": "string",
  "email": "string",
  "password": "string"
}
````

**Response**

```json
{
  "status": "success",
  "message": "User registered successfully",
  "data": null
}
```

---

### Login User

**POST /auth/login**

**Request Body**

```json
{
  "email": "string",
  "password": "string"
}
```

**Response**

```json
{
  "status": "success",
  "message": "Login successful",
  "data": "jwt-token-string"
}
```

---

## Posts

### Get All Posts

**GET /posts**

**Query Parameters (optional)**

* `pageNo` (default: 0)
* `limit` (default: 10)

**Response**

```json
{
  "status": "success",
  "message": "Posts fetched successfully",
  "data": [
    {
      "id": 1,
      "title": "Post Title",
      "content": "Post content",
      "createdAt": "2025-11-01T10:00:00Z",
      "updatedAt": "2025-11-01T10:00:00Z",
      "author": {
        "name": "Author Name"
      }
    }
  ]
}
```

---

### Get Post by ID

**GET /posts/{id}**

**Response**

```json
{
  "status": "success",
  "message": "Post fetched successfully",
  "data": {
    "id": 1,
    "title": "Post Title",
    "content": "Post content",
    "createdAt": "2025-11-01T10:00:00Z",
    "updatedAt": "2025-11-01T10:00:00Z",
    "author": {
      "name": "Author Name"
    }
  }
}
```

---

### Create Post

**POST /admin/posts**
**Headers**

```
Authorization: Bearer {jwt-token}
```

**Request Body**

```json
{
  "title": "Post Title",
  "content": "Post content"
}
```

**Response**

```json
{
  "status": "success",
  "message": "Post created successfully",
  "data": {
    "id": 1,
    "title": "Post Title",
    "content": "Post content",
    "createdAt": "2025-11-01T10:00:00Z",
    "author": {
      "name": "Author Name"
    }
  }
}
```

---

### Update Post

**PUT /admin/posts/{id}**
**Headers**

```
Authorization: Bearer {jwt-token}
```

**Request Body**

```json
{
  "title": "Updated Title",
  "content": "Updated content"
}
```

**Response**

```json
{
  "status": "success",
  "message": "Post updated successfully",
  "data": {
    "id": 1,
    "title": "Updated Title",
    "content": "Updated content",
    "createdAt": "2025-11-01T10:00:00Z",
    "updatedAt": "2025-11-01T11:00:00Z",
    "author": {
      "name": "Author Name"
    }
  }
}
```

---

### Delete Post

**DELETE /admin/posts/{id}**
**Headers**

```
Authorization: Bearer {jwt-token}
```

**Response**

```json
{
  "status": "success",
  "message": "Post deleted successfully",
  "data": {
    "id": 1
  }
}
```


