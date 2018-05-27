<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.lockit.entity.HouseOwner,com.lockit.entity.Video,java.util.*" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Home | LOCKIT</title>

        <!-- Bootstrap Core CSS -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="../css/metisMenu.min.css" rel="stylesheet">

        <!-- Timeline CSS -->
        <link href="../css/timeline.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="../css/startmin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="../css/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css">


        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
		
		
		<style>
					.column {
				float: left;
				width: 30%;
				padding: 50px;
				border-style:solid;
			
				display:block;
				
			}

			.row{
			
			    margin-left:auto;
				margin-right:auto;
				margin-top:auto;
				display:block;
			}
		
		
		</style>
	
<script>	
	// Get the elements with class="column"
var elements = document.getElementsByClassName("column");

// Declare a loop variable
var i;

// List View
function listView() {
  for (i = 0; i < elements.length; i++) {
    elements[i].style.width = "100%";
  }
}

// Grid View
function gridView() {
  for (i = 0; i < elements.length; i++) {
    elements[i].style.width = "30%";
  }
}

	
		</script>
		
    </head>
    <body>

        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="navbar-header">
                    <a class="navbar-brand" href="homepage.jsp">LockIT!</a>
                </div>

                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <ul class="nav navbar-nav navbar-left navbar-top-links">
                    <li><a href="../../index.jsp"><i class="fa fa-home fa-fw"></i> Go Website</a></li>
                </ul>

				
                <ul class="nav navbar-right navbar-top-links">
                    <li class="dropdown navbar-inverse">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-bell fa-fw"></i> <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-comment fa-fw"></i> New Comment
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                        <span class="pull-right text-muted small">12 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-envelope fa-fw"></i> Message Sent
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-tasks fa-fw"></i> New Task
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a class="text-center" href="#">
                                    <strong>See All Alerts</strong>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i> <% if(session.getAttribute("userName") != null) { HouseOwner user = (HouseOwner) session.getAttribute("userName"); out.print(user.getUserName());} %> <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                            </li>
                            <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="../../logoutController"><i class="fa fa-sign-out fa-fw"></i> Logout</a></li>
                        </ul>
                    </li>
                </ul>
                <!-- /.navbar-top-links -->

                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">
                            <li class="sidebar-search">
                             <img src="../../images/favicon.ico" alt="">                       
                            </li>
                            <li>
                                <a href="homepage.jsp"><i class="fa fa-dashboard fa-fw"></i> MyDashboard</a>
                            </li>
							<li>
                                <a href="register.jsp" ><i class="fa fa-edit fa-fw"></i> Register Device</a>
                            </li>
							<li>
                                <a href="device.jsp" ><i class="fa fa-bar-chart-o fa-fw"></i> Device Status</a>
                            </li>
                            <li>
                                <a href="../../CCTVController" class="active"><i class="fa fa-eye fa-fw"></i> CCTV Status</a>
                            </li>
                            <li>
                                <a href="activity.jsp"><i class="fa fa-wrench fa-fw"></i> Activity Log</a>
                            </li>
                          
                        </ul>
                    </div>
                </div>
            </nav>

			<!---------------------------navbar on lefttt------------------------------>
			
			
            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">CCTV</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row ---------------4 gui dashboard---------->
                
				

							

				<!-- Buttons to choose list or grid view -->
				<button onclick="listView()"><i class="fa fa-bars"></i> List</button> 
				<button onclick="gridView()"><i class="fa fa-th-large"></i> Grid</button> 

				<div class="row">
				  <% 
				  if(session.getAttribute("videoList") != null) {
				  	for(Video video : (List<Video>) session.getAttribute("videoList")) {
				  		
				  %>
				  	
				  
				  <div class="column" style="background-color:#bbb;">
					<h2>CAM 3 </h2>
					<p>Location: <% out.print(video.getLockEye_Video().getEyeLocation()); %></p>
					<video width="320" height="240" autoplay>
						<source src="<% out.print(video.getVideoClip()); %>" type="video/mp4">
					</video>
				  </div>
				  
				  <% 
				  	}
				  }
				  %>
				 
				</div>

				
				<div class="row">
				  <div class="column" style="background-color:#ccc;">
					<h2>CAM 4</h2>
				<i class="fa fa-eye fa-5x"></i>
				  </div>
				  
				  <div class="column" style="background-color:#ddd;">
					<h2>CAM 5</h2>
					<i class="fa fa-eye fa-5x"></i>
				  </div>
				  
				  <div class="column" style="background-color:#bbb;">
					<h2>CAM 6</h2>
					<i class="fa fa-eye fa-5x"></i>
				  </div>
				</div>
								
									
				<div class="row">
				  <div class="column" style="background-color:#ccc;">
					<h2>CAM 7</h2>
					<i class="fa fa-eye fa-5x"></i>
				  </div>
				  
				  <div class="column" style="background-color:#ddd;">
					<h2>CAM 8</h2>
					<i class="fa fa-eye fa-5x"></i>
				  </div>
				  
				  <div class="column" style="background-color:#bbb;">
					<h2>CAM 9</h2>
					<i class="fa fa-eye fa-5x"></i>
				  </div>
				</div>
				
				
				
				
				
							</div>
							<!-- /#page-wrapper -->

						</div>
        <!-- /#wrapper -->
		
		
		
		
		
		

        <!-- jQuery -->
        <script src="../js/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="../js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="../js/metisMenu.min.js"></script>

        <!-- Morris Charts JavaScript -->
        <script src="../js/raphael.min.js"></script>
        <script src="../js/morris.min.js"></script>
        <script src="../js/morris-data.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="../js/startmin.js"></script>

    </body>
</html>
