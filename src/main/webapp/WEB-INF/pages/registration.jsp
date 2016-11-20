<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
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

<style>

	.error {
		color: #ff0000;
	}
</style>

</head>
<body>

    <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">
                    <i class="fa fa-play-circle"></i> 
                    	<span class="light">Start</span> Registering Your Event To Create Booking
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

    <!-- Main Content -->
<section id="contact" class=" content-section text-center">
	<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<div class="wow bounceInDown" data-wow-delay="0.4s">
					<h2>Register Event</h2>
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
		<div class="col-lg-2">
		</div>
	  <div class="col-lg-9">
       <div class="boxed-grey">
		<form:form id="contact-form" method="POST" modelAttribute="events" commandName="events">
			<form:input type="hidden" path="id" />
			<div class="row" >
	            <div class="col-md-5">
		             <div class="form-group">
		             	 <label for="eventname">Event Name</label>
		                 <form:input path="eventname" type="text" class="form-control" id="name" placeholder="Enter Event Name" required="required" />
			             <p class="help-block text-danger"></p>
			         </div>
			         <div class="form-group">
		                  <label for="event date" >Event Date</label>
		                  <form:input path="date" type="text" class="form-control" id="name" placeholder="Enter event date dd/MM/yyyy " required="required" />
		             </div>
		             <div class="form-group">
		                  <label for="Ticket Price:" >Ticket Price</label>
		                  <form:input path="price" type="text" class="form-control" id="name" placeholder="Enter ticket price " required="required" />
		             </div>
		             <div class="form-group">
		                  <label for="Happening At" >Happening At</label>
		                  <form:input path="location" type="text" class="form-control" id="name" placeholder="Enter event location " required="required" />
		             </div>
	            </div>
	            <div class="col-md-5">
		             <div class="form-group">
		                  <label for="event Address" >Address</label>
		                  <form:input path="Address" type="text" class="form-control" id="name" placeholder="Enter event address " required="required" />
		             </div>
		             <div class="form-group">
		                  <label for="contact" >Event Contact</label>
		                  <form:input path="Contact_no" type="text" class="form-control" id="name" placeholder="Enter contact no " required="required" />
		             </div>
		             <div class="form-group">
		                  <label for="alt contact" >Alternative contact</label>
		                  <form:input path="alternate_contact" type="text" class="form-control" id="name" placeholder="Enter Alternate contact " required="required" />
		             </div>
		             <div class="form-group">
		                  <label for="mail_address" >Mail Address</label>
		                  <form:input path="mail_address" type="text" class="form-control" id="name" placeholder="Enter Mail Address" required="required" />
		             </div>
		             <div class="form-group">
			             <div class="col-sm-offset-2 col-sm-10"> 
				        	<c:choose>
								<c:when test="${edit}">
									<button class="btn btn-default" type="submit" value="Update">Update</button>
								</c:when>
								<c:otherwise>
									<button class="btn btn-default" type="submit" value="Register">Register</button>
								</c:otherwise>
							</c:choose>
		        		</div>
		        	 </div>
	            </div>
	            
	      </div>
        </form:form>                   
	</div>
  </div>
</div>
<hr>
</section>


    <!--  div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <p></p>
                <!-- Contact Form - Enter your email address on line 19 of the mail/contact_me.php file to make this form work. -->
                <!-- WARNING: Some web hosts do not allow emails to be sent through forms to common mail hosts like Gmail or Yahoo. It's recommended that you use a private domain email address! -->
                <!-- NOTE: To use the contact form, your site must be on a live web host with PHP! The form will not work locally! 
                <form:form method="POST" modelAttribute="events" commandName="events" name="sentMessage" id="contactForm" novalidate="">
		        <form:input type="hidden" path="id" />
                    
                    <div class="row control-group">
                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Message</label>
                            <textarea rows="5" class="form-control" placeholder="Message" id="message" required="" data-validation-required-message="Please enter a message."></textarea>
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <br>
                    <div id="success"></div>
                    <div class="row">
                        <div class="form-group col-xs-12">
                            <button type="submit" class="btn btn-default">Send</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div-->

   

    <!-- Footer-->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10  col-md-offset-1">
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
                    
                    
                </div>
            </div>
        </div>
    </footer> 

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
   
