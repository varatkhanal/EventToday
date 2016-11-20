<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register ac</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Events Registration Form</title>
	<!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"/>" >

    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/vendor/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="http://fonts.googleapis.com/css?family=Montserrat:400,700"/>" rel="stylesheet" type="text/css">

    <!-- Theme CSS -->
    <link href="<c:url value="/resources/css/grayscale.min.css"/>" rel="stylesheet">
</head>
<body>

  <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">
                    <i class="fa fa-play-circle"></i> <span class="light">Start</span> Registering Your Event To Create Booking
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
                        <a class="page-scroll" href="#about">Home </a>
                    </li>
                    <!--  li>
                        <a class="page-scroll" href="#download">Events</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#contact">Contact</a>
                    </li-->
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
  </nav>
    
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
      
  <section id="contact" class=" content-section text-center">
	<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<div class="wow bounceInDown" data-wow-delay="0.4s">
						<h2>Register Organizer Profile</h2>
						<i class="fa fa-2x fa-angle-down"></i>
					</div>
				</div>
	</div>
	<div class="row">
			<div class="col-lg-12">
				<hr class="marginbot-50">
			</div>
	</div>       
 	<div class="container">
		 	<div class="row">
		      <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				 <div class="boxed-grey">
					<form:form id="contact-form" method="POST" modelAttribute="Organizer" commandName="Organizer">
					<form:input type="hidden" path="roid" />
					    <div class="form-group col-xs-6 floating-label-form-group controls">
					        <label>Event Organizer Name</label>
					        <form:input path="organizerName" id="orgName" class="form-control" type="text" value=""/>
				        </div>
					    <div class="form-group col-xs-6 floating-label-form-group controls">
					        <label>Address</label>
					        <form:input path="orgAddress" id="orgAddress" class="form-control" type="text" value=""/>      
					     </div>
					    <div class="form-group col-xs-6 floating-label-form-group controls ">
					        <label>City</label>
					         <input id="orgCity" name="orgCity" class="form-control" type="text" value="">     
					    </div>
					    <div class="form-group col-xs-6 floating-label-form-group controls">
					        <label>Mail Address</label>
					        <!--  div class="col-sm-5">-->
					            <input id="mailAddress" name="mailAddress" class="form-control" type="text" value="">
					    </div>
					    <div class="form-group col-xs-6 floating-label-form-group controls ">
					        <label>Telephone</label>
					        <input id="orgTelephone" name="orgTelephone" class="form-control" type="text" value="">
					    </div>
					    <div class="form-group col-xs-6 floating-label-form-group controls ">
					        <label>Alternate Contact</label>
					        <input id="altContact" name="altContact" class="form-control" type="text" value="">
					    </div>
				        
		    		</form:form>
				</div>
				<div class="form-group floating-label-form-group controls">
					 <button class="btn btn-default" type="submit">Add Organizer</button>
				</div>
			</div>
		</div>
		</div>
		<hr>
		<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
						<a href="<c:url value='/new' />" class="btn btn-default btn-lg">Create My event Booking!</a>
					</div>
				</div>
			</div>
</section>>
<!-- to herna  -->

        <form class="form-register" method="post" action="#">

            <div class="form-register-with-email">

                <div class="form-white-background">

                    <div class="form-title-row">
                        <h1>Create an account</h1>
                    </div>

                    <div class="form-row">
                        <label>
                            <span>Name</span>
                            <input type="text" name="name">
                        </label>
                    </div>

                    <div class="form-row">
                        <label>
                            <span>Email</span>
                            <input type="email" name="email">
                        </label>
                    </div>

                    <div class="form-row">
                        <label>
                            <span>Password</span>
                            <input type="password" name="password">
                        </label>
                    </div>

                    <div class="form-row">
                        <label class="form-checkbox">
                            <input type="checkbox" name="checkbox" checked="">
                            <span>I agree to the <a href="#">terms and conditions</a></span>
                        </label>
                    </div>

                    <div class="form-row">
                        <button type="submit">Register</button>
                    </div>

                </div>

                <a href="#" class="form-log-in-with-existing">Already have an account? Login here →</a>

            </div>

            <div class="form-sign-in-with-social">

                <div class="form-row form-title-row">
                    <span class="form-title">Sign in with</span>
                </div>

                <a href="#" class="form-google-button">Google</a>
                <a href="#" class="form-facebook-button">Facebook</a>
                <a href="#" class="form-twitter-button">Twitter</a>

            </div>

        </form>

    </div>
</body>
</html>
<!-- jQuery -->
    <script src="<c:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js"/>"></script>

    <!-- Contact Form JavaScript -->
    <script src="<c:url value="/resources/js/jqBootstrapValidation.js"/>"></script>
    <script src="<c:url value="/resources/js/contact_me.js"/>"></script>

    <!-- Theme JavaScript -->
    <script src="<c:url value="/resources/js/clean-blog.min.js"/>"></script>
    <!-- Theme JavaScript -->
    <script src="<c:url value="/resources/js/grayscale.min.js"/>"></script>