[![codecov](https://codecov.io/gh/vald3r/reactive-gateway/branch/master/graph/badge.svg?token=6H4ZNYSRLJ)](https://codecov.io/gh/vald3r/reactive-gateway)

- all services\
  [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=vald3r_reactive-gateway&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=vald3r_reactive-gateway)
- product-service \
  [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=vald3r_reactive-gateway_customer-orders-gateway&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=vald3r_reactive-gateway_customer-orders-gateway)
- customer-orders-gateway \
  [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=vald3r_reactive-gateway_customer-service&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=vald3r_reactive-gateway_customer-service)
- customer-service \
  [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=vald3r_reactive-gateway_order-sevice&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=vald3r_reactive-gateway_order-sevice)
- order-sevice

# Reactive gateway service

There is a microservice architecture which contains 3 microservices. Each service has external REST endpoints to support
several types of clients (web, android, ios). To display the page with orders for a certain customers the information
should be obtained from all three microservices: customer-service to display name of the customer, order-service to
display all orders, product-service to display product information in orders. In this case, requests can be made
asynchronously:

`1 Thread) getting order -> getting products for orders`

`2 Thread) getting customer info`

Such requests potentially slow down clients. But there is a solution to this problem: API gateway. API gateway accepts a
single request to display information and obtain information from all other repositories.

The main idea was to write a simple gateway which will resolve one request:

`GET /api/v1/orders/?client_id={{id}}` - where id is the identifier in the customer-service. The request should return
all orders for the customer in the format described below:

```
{
	customerName: [[string]],
	orders: [
		{
			id: [[number]],
			productId: [[number]],
			productTitle: [[string]]
		}
	]
}
```

Gateway should use these requests from three different microservices:

### Order-service

`GET /api/v1/orders/?client_id={{id}}` - getting all order for the customer with `id`

Response format:

```
[
	{
		id: [[number]],
		productId: [[number]]
	}
]
```

### Product-service

`GET /api/v1/products/{{id}}` - getting product info for the product with `id`

Response format:

```
{
	id: [[number]],
	title: [[string]]
}
```

### Customer-service

`GET /api/v1/users/{{id}}` - getting information about customer with `id`

Response format:

```
{
	id: [[number]],
	name: [[string]],
}
```