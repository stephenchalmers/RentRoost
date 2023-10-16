
<h1 align="center">
  <br>
  <a href="https://github.com/StephenChalmers/rentroost"><img src="https://raw.githubusercontent.com/Thomas-Fitz/RentRoost/main/vue/public/images/logo.png" alt="RentRoost" width="350"></a>
</h1>

<h4 align="center">A minimum-viable real estate web application built with Vue.js and Java Spring Boot.</h4>

<p align="center">
  <a href="#key-features">Key Features</a> •
  <a href="#how-to-use">How To Use</a> •
  <a href="#Screenshots"> Screenshots</a> •
  <a href="#credits">Credits</a>
</p>

## Key Features
* Google Maps Integration
  - Properties pinned in map location. Geocoding information automatically tagged when a new property is added.
  - Pin clusters automatically generated based on pin volume in map area.
  - Property details available on pin click.
* Distinct functionality for landlord vs application vs unauthenticated user.


## How To Use

Step One: Clone this repository

```bash
# Clone this repo
$ git clone https://github.com/StephenChalmers/rentroost.git
```

Step Two: Setup the Database
* Install and run a PostgreSQL Server
* Create a new database called rental_property_db
* Open dropdb.sql and run
* Open schema.sql and run
* Open user.sql and run
* Open property.sql and run
* Open data.sql and run

Step Three: Setup and run the frontend / backend servers

```bash
# Clone this repository
$ git clone https://github.com/StephenChalmers/rentroost.git

# Go into the Vue directory
$ cd Vue

# Install dependencies
$ npm install

# Run the app
$ npm run serve

# Go into main the backend directory
$ cd ../java/src/main/java/com/techelevator/

# Run the backend server
```

## Screenshots


Login page:
![Screenshot 2023-03-07 115214](https://user-images.githubusercontent.com/110345269/223492693-10346461-66fe-4707-a0c9-d1630cc3bb39.png)

Registration page: 
![Screenshot 2023-03-07 115250](https://user-images.githubusercontent.com/110345269/223492728-279073ca-1cc9-4a0a-9672-7e017d65dbe0.png)

Home page for anonymous user: 
![Screen Shot 2023-02-28 at 3 48 24 PM (1)](https://user-images.githubusercontent.com/110345269/223490548-7c1cb80b-a6d8-4f5d-aa49-39dc60c9b058.png)

View Selected property on map:
![Screen Shot 2023-02-28 at 3 48 38 PM (1)](https://user-images.githubusercontent.com/110345269/223490541-bed8263d-0e3d-41c1-b927-ab06d1b2b84f.png)

View selected property with similar propertes below:
![Screen Shot 2023-02-28 at 3 48 48 PM (1)](https://user-images.githubusercontent.com/110345269/223490537-87c5948f-067f-48fd-b6f2-8aaf27eb28d2.png)

Tenants page to make maintainence requests or pay rent:
![Screenshot 2023-03-07 120049](https://user-images.githubusercontent.com/110345269/223494816-c06688c0-cf26-435c-97e0-c888f1d52f33.png)

Contact Us page:
![Screenshot 2023-03-07 115817](https://user-images.githubusercontent.com/110345269/223495076-d38b96bc-7bd1-46c7-8fd9-db2fe91a3d22.png)


## Credits
This software uses the following open source packages:

- [Vue.js](https://vuejs.org/)
- [vue2-google-maps](https://github.com/xkjyeah/vue-google-maps)
- [Java Spring Boot](https://spring.io/)
