The keystone of AJAX is the XMLHttpRequest object.

- Create an XMLHttpRequest object
- Define a callback function
- Open the XMLHttpRequest object
- Send a Request to a server

Define a Callback Function
- 1 cái hàm được chuẩn bị trước và gọi lại sau đó -> được gọi là callback

Send a Request
- 1 cái data gửi lên theo công thức nào --> send lên

XMLHttpRequest Object Methods
- open(method, url, async, user, psw)
- setRequestHeader thêm cặp table value để gửi cho method post

XMLHttpRequest Object Properties
- onload	
  - Defines a function to be called when the request is received (loaded)
- status	Returns the status-number of a request
  - 200: "OK"
  - 403: "Forbidden"
  - 404: "Not Found"
For a complete list go to the Http Messages Reference
statusText	Returns the status-text (e.g. "OK" or "Not Found")
