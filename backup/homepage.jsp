<!doctype html>
<html lang="en">
  <head>
   
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

   
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/style.css">
    <title>E-CommerceApp</title>
  </head>
  <body>
    <nav class="navbar navbar-expand-lg bh-white">
        <div class="container-fluid">
          <a class="navbar-brand" href="homepage.jsp">Home</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          
          <div class="collapse navbar-collapse "id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active " aria-current="page" href="ListProducts.jsp">Products</a>
              </li>
              
              <li class="nav-item">
                <a class="nav-link" href="#">My Cart</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active " aria-current="page" href="#">Logout</a>
              </li>
              <!-- - 
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Dropdown
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item " href="#">Action</a></li>
                  <li><a class="dropdown-item " href="#">Another action</a></li>
                  <li><hr class="dropdown-divider "></li>
                  <li><a class="dropdown-item " href="#">Something else here</a></li>
                </ul>
              </li>
              -->
             
            </ul>
             <!-- -
            <form class="d-flex">
              <input class="form-control me-2" type="search" placeholder="Search  for products,brands and more" aria-label="Search" size="30">
              <a href="SearchProducts.jsp"><input type="button" value="Search" class="btn btn-outline-success"></a>
            </form>
             -->  
          </div>
        </div>
      </nav>
      <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="assets/img/mobile.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
             <div  class="container">
                 <div class="row">
                     <div class="col-lg-2 mx-auto"></div>
                         <h1>Summer Sale 2021</h1>
                         <h1>Get upto 25%  offer !!!!</h1>
                         </div>
             </div>
            </div>
          </div>
          <div class="carousel-item">
            <img src="assets/img/watch.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
                  <h1>Get upto 45%  offer on every Watches!!!!</h1>
            
            </div>
          </div>
          <div class="carousel-item">
            <img src="assets/img/chairs.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
                    <h1>Get upto 75%  offer !!!!</h1>
            </div>
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
  
    <section class="collection">
        <div class="container py-5">
            <h1 class="text-center">Our Products</h1>
            <div class="row py-5">
            <div class="col-lg-3">
                <div class="card">
                    <img src="assets/img/smartwatches.jpeg" class="img-fluid mb-3" alt="">
                   <a href="LoginPage.jsp"><input type="button" value="Add to cart"></a>
                    <h5>Smart Watches</h5>
                    <p><small><del> Rs.6800</del><span> Rs.2500</span></small></p>
                </divclass>
            </div>
            <div class="col-lg-3">
                    <div class="card">
                        <img src="assets/img/smartv.jpg" class="img-fluid mb-3" alt="">
                      <a href="LoginPage.jsp"><input type="button" value="Add to cart"></a>
                        <h5>Smart Tv</h5>
                        <p><small><del> Rs.90,000</del><span> Rs.78,000</span></small></p>
                    </divclass>
                </div>
                <div class="col-lg-3">
                        <div class="card">
                            <img src="assets/img/chairs.jpg" class="img-fluid mb-3" alt="">
                           <a href="LoginPage.jsp"><input type="button" value="Add to cart"></a>
                            <h5>Chairs</h5>
                            <p><small><del> Rs.6700</del><span> Rs.4800</span></small></p>
                        </divclass>
                    </div>
                    <div class="col-lg-3">
                            <div class="card">
                                <img src="assets/img/camera.jpg" class="img-fluid mb-3" alt="">
                                <a href="LoginPage.jsp"><input type="button" value="Add to cart"></a>
                                <h5>Camera</h5>
                                <p><small><del> Rs.1,95,000</del><span> Rs.1,67,000</span></small></p>
                            </divclass>
                        </div>
           
          
        </div>


    </section>
    <section class="collection">
            <div class="container py-5">
                <h1 class="text-center">Most Popular Products</h1>
                <div class="row py-5">
                <div class="col-lg-3">
                    <div class="card">
                        <img src="assets/img/shoes.jpg" class="img-fluid mb-3" alt="">
                        <a href="LoginPage.jsp"><input type="button" value="Add to cart"></a>
                        <h5>Shoes</h5>
                        <p><small><del> Rs.3400</del><span> Rs.2500</span></small></p>
                    </divclass>
                </div>
                <div class="col-lg-3">
                        <div class="card">
                            <img src="assets/img/eaphones.jpg" class="img-fluid mb-3" alt="">
                           <a href="LoginPage.jsp"><input type="button" value="Add to cart"></a>
                            <h5>Air pods</h5>
                            <p><small><del> Rs.15,000</del><span> Rs.12,700</span></small></p>
                        </divclass>
                    </div>
                    <div class="col-lg-3">
                            <div class="card">
                                <img src="assets/img/smartphone.jpg" class="img-fluid mb-3" alt="">
                                <a href="LoginPage.jsp"><input type="button" value="Add to cart"></a>
                                <h5>Smart Phone</h5>
                                <p><small><del> Rs.67,000</del><span> Rs.48,000</span></small></p>
                            </divclass>
                        </div>
                        <div class="col-lg-3">
                                <div class="card">
                                    <img src="assets/img/colorpencils.jpg" class="img-fluid mb-3" alt="">
                                    <a href="LoginPage.jsp"><input type="button" value="Add to cart"></a>
                                    <h5>ColorPencils</h5>
                                    <p><small><del> Rs.240</del><span> Rs.120</span></small></p>
                                </divclass>
                            </div>
                        </div>
    
  </section>


   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

  </body>
</html>