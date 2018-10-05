# spring-boot-microservices


Test using postman:
http://localhost:8080/productDetails/ --> Get reterive all product details

POST --> to add product in catalogue
{
	"productName":"samsungs8",
	"productType":"Mobile",
	"description":"20MP+16MP primary dual camera and 16MP front facing camera",
	"price":"48990",
	"vendorCode":"0001"
	
}

http://localhost:8080/productDetails/search/findByproductType?productType=Mobile --> to retrive product details using sending product Type

http://localhost:8080/productDetails/4 --> to delete product passing product Id