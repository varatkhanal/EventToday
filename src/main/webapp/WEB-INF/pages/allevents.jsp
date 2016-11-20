
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Event Nepal - event details</title>

    <!--base href="${pageContext.request.contextPath}"-->

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"/>" >

    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/vendor/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="http://fonts.googleapis.com/css?family=Montserrat:400,700"/>" rel="stylesheet" type="text/css">

    <!-- Theme CSS -->
    <link href="<c:url value="/resources/css/grayscale.min.css"/>" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

    <!-- Navigation -->
    <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">
                    <i class="fa fa-play-circle"></i> <span class="light">Start</span> Eventing
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <ul class="nav navbar-nav">
                    <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#about">About </a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#download">Events</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#contact">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Intro Header -->
    <header class="intro">
        <div class="intro-body">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <h1 class="brand-heading">Event Nepal</h1>
                        <p class="intro-text">A surrenderous pick-hunt event booking
                            <br></p>
                        <a href="#about" class="btn btn-circle page-scroll">
                            <i class="fa fa-angle-double-down animated"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- About Section -->
    <section id="about" class="container content-section text-center">
        <div class="row" >
            <div class="col-lg-8 col-lg-offset-2">
                <h2>Create your booking</h2>
                <p>Initiate your business with it venture to get through breakpoint. </p>
                <p>Along with a custom and service at your door step we have a experince of lernding hands with <a href="http://plus545.com.np/">+5:45 network</a>.</p>
                <p>it includes booking managing and advertisizing your events in the digital world</p>
            </div>
            <a href="<c:url value='/registerAc' />" class="btn btn-default btn-lg">Register My Acount To Create event Booking!</a><br>
            <br>
	    <!--a href="<c:url value='/new' />" class="btn btn-default btn-lg">Create My event Booking!</a-->
	    
        </div>
    </section>

    <!-- Download Section 
    <section id="download" class="content-section text-center">
        <div class="download-section">
            <div class="container">
                <div class="col-lg-8 col-lg-offset-2">
                    <h2>Book My event</h2>
                    <p></p>
                    <a href="#" class="btn btn-default btn-lg">Book it!</a>
                </div>
            </div>
        </div>
    </section>-->
<section id="download" class="content-section text-center">
    <div class="container">
        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">Make Your Booking
                    </h2>
                    <hr>
                </div>
		<c:forEach items="${evnts}" var="evnts">
                <div class="col-lg-12 text-center">
		    
                    <img class="img-responsive img-border img-full" src="" alt="">
                    <h3>Event: ${evnts.eventname}
                        <br>
                        <small>Date:${evnts.date}</small>
                    </h3>
		    <h3>Ticket Price: ${evnts.price}</h3>
		    		<h5>Happening at<br>
		       ${evnts.location},${evnts.address}
                        <br>
                        <small>Time:</small></h5>
            		<h5>Contact Details: </h5><br>
            		${evnts.contact_no},${evnts.mail_address} <h5>
                    <a href="#" class="btn btn-default btn-lg">book it</a>
                    <hr>
                    <br>
                </div>
		</c:forEach>
                <div class="col-lg-12 text-center">
                    <ul class="pager">
                        <li class="previous"><a href="#"> Older</a>
                        </li>
                        <li class="next"><a href="#">Newer →</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>


    <section id="contact" class=" content-section text-center">
		<!--div class="heading-contact">
			<!--div class="container"-->
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<div class="wow bounceInDown" data-wow-delay="0.4s">
					<!--div class="section-heading"-->
					<h2>Get in touch</h2>
					<i class="fa fa-2x fa-angle-down"></i>

					<!--/div-->
					</div>
				</div>
			</div>
			<!--/div-->
		<!--/div-->
<div class="row">
			<div class="col-lg-2 col-lg-offset-5">
				<hr class="marginbot-50">
			</div>
</div>
<div class="container">

    <div class="row">
        <div class="col-lg-8">
            <div class="boxed-grey">
                <form id="contact-form">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="name" >
                               </label>
                            <input type="text" class="form-control" id="name" placeholder="Enter name" required="required" />
                        </div>
                        <div class="form-group">
                            <label for="email">
                                &nsbp</label>
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span>
                                </span>
                                <input type="email" class="form-control" id="email" placeholder="Enter email" required="required" /></div>
                        </div>
                        <div class="form-group">
                            <label for="subject">
                               &nsbp</label>
                            <select id="subject" name="subject" class="form-control" required="required">
                                <option value="na" selected="">Choose One:</option>
                                <option value="service">General Customer Service</option>
                                <option value="suggestions">Suggestions</option>
                                <option value="product">Product Support</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <!-- label for="name">
                                Message</label-->
                            <textarea name="message" id="message" class="form-control" rows="9" cols="25" required="required"
                                placeholder="Message"></textarea>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-skin pull-right" id="btnContactUs">
                            Send Message</button>
                    </div>
                </div>
                </form>
            </div>
        </div>
		
		<div class="col-lg-4">
			<div class="widget-contact" id="contact-form">
				<h5>Main Office</h5>
				
				<address>
				  <strong>+5:45 tech, Inc.</strong><br>
				  MB tower<br>
				  Anamnagar, Laliguras gha3467<br>
				  <abbr title="Phone">P:</abbr> (123) 456-7890
				</address>

				<address>
				  <strong>Email</strong><br>
				  <a href="mailto:#">info@plus545.com.np</a>
				</address>	
				<address>
				  <strong>We're on social networks</strong><br>
			            <!--  ul class="list-inline banner-social-buttons">
                            <li class="btn-default "><a href="#" target="_blank"><i class="fa fa-facebook fa-fw"></i></a></li>
                            <li class="btn-default"><a href="#" target="_blank"><i class="fa fa-twitter fa-fw"></i></a></li>
                            <li class="btn-default"><a href="#" target="_blank"><i class="fa fa-google-plus fa-fw"></i></a></li>
                        </ul-->
                        <ul class="list-inline text-center">
                        <li>
                            <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                    </ul>
			</address>					
			
			</div>	
		</div>
    </div>	

		</div>
	</section>

	<!-- /Section: contact -->

    <!-- Map Section >
    <div id="map"></div-->

    <!-- Footer -->
    <footer>
        <div class="container text-center">
            <p>Copyright &copy; Your Website 2016</p>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="<c:url value="/resources/vendor/jquery/jquery.js"/>"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js"/>"></script>

    <!-- Plugin JavaScript -->
    <script src="<c:url value="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"/>"></script>

    <!-- Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
    <script type="text/javascript" src="<c:url value="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"/>"></script>

    <!-- Theme JavaScript -->
    <script src="<c:url value="/resources/js/grayscale.min.js"/>"></script>

</body>

