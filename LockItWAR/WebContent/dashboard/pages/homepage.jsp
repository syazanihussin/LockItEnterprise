<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.lockit.entity.HouseOwner,com.lockit.ejb.SenseNotificationBean,com.lockit.ejb.dao.local.SenseNotificationBeanLocal,com.lockit.ejb.logic.local.SenseNotificationLogicLocal,com.lockit.entity.SenseNotification,com.lockit.ejb.logic.local.NotificationLogicLocal,com.lockit.ejb.logic.local.VideoLogicLocal,com.lockit.ejb.NotificationBean,com.lockit.ejb.VideoBean,com.lockit.ejb.logic.local.LockEyeLogicLocal,com.lockit.ejb.logic.local.LockSenseLogicLocal,com.lockit.ejb.LockSenseBean,com.lockit.ejb.LockEyeBean" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Homepage | LOCKIT</title>

        <!-- Bootstrap Core CSS -->
        <link href="dashboard/css/bootstrap.min.css" rel="stylesheet">
		
		
		<link rel="icon"  href="images/favicon.ico"/>

        <!-- MetisMenu CSS -->
        <link href="dashboard/css/metisMenu.min.css" rel="stylesheet">

        <!-- Timeline CSS -->
        <link href="dashboard/css/timeline.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="dashboard/css/startmin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="dashboard/css/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="dashboard/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
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
                    <li><a href="index.jsp"><i class="fa fa-home fa-fw"></i> Go Website</a></li>
                </ul>

				
				<!---------------------------------notification panel------------------------------------------------>
                <ul class="nav navbar-right navbar-top-links">
                    <li class="dropdown navbar-inverse">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-bell fa-fw"></i> <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">
                        
                        
                            <li class="divider"></li>
                        </ul>
                    </li>
					<!------------------------------------------notification panel-------------------------------->

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
							<li><a href="logoutController"><i class="fa fa-sign-out fa-fw"></i> Logout</a></li>
                        </ul>
                    </li>
                </ul>
                <!-- /.navbar-top-links -->

                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">
                            <li class="sidebar-search">
                             <img src="images/favicon.ico" alt="">                       
                            </li>
                            <li>
                                <a href="dashboardController" class="active"><i class="fa fa-dashboard fa-fw"></i> MyDashboard</a>
                            </li>
							<li>
                                <a href="registerController" ><i class="fa fa-edit fa-fw"></i> Register Device</a>
                            </li>
							<li>
                                <a href="DeviceStatusController" ><i class="fa fa-bar-chart-o fa-fw"></i> Device Status</a>
                            </li>
                            <li>
                                <a href="CCTVController"><i class="fa fa-eye fa-fw"></i> CCTV Status</a>
                            </li>
                           
                 
                        </ul>
                    </div>
                </div>
            </nav>

			<!---------------------------navbar on lefttt------------------------------>
			
			
            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Home</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row ---------------4 gui dashboard---------->
                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-comments fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"><% 
                                        
                                        NotificationLogicLocal notificationLogicLocal = new NotificationBean() ;                               		
                                		int total = notificationLogicLocal.calculateTotalNotifications();
                                		
                                        out.print(total);%></div>
                                        <div>Notification</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>

                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-tasks fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"><% 
                                       	
                                       	VideoLogicLocal videoLogicLocal = new VideoBean();
                                        double remain = videoLogicLocal.calculateRemainingSpace();
                                        
                                        out.print(remain);%></div>
                                        <div>Storage</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>

                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-home fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"><%
                                        
                                        LockSenseLogicLocal lockSenseLogicLocal = new LockSenseBean();
                                        int totalLockSense=lockSenseLogicLocal.calculateTotalLockSense();
                                        
                                        out.print(totalLockSense);%></div>
                                        <div>LockSense</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>

                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-eye fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"><%
                                        
                                        LockEyeLogicLocal lockEyeLogicLocal = new LockEyeBean();
                                        int totalLockEye =lockEyeLogicLocal.calculateTotalLockEye();
                                        
                                        out.print(totalLockEye);%></div>
                                        <div>LockEye</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>

                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
				<!------------------------end 4 guis here------------------------------------------------------------>
				

                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-8">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-bar-chart-o fa-fw"></i> Most Active Devices
                                <div class="pull-right">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default btn-xs dropdown-toggle"
                                                data-toggle="dropdown">
                                            Actions
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu pull-right" role="menu">
                                            <li><a href="#">Action</a>
                                            </li>
                                            <li><a href="#">Another action</a>
                                            </li>
                                            <li><a href="#">Something else here</a>
                                            </li>
                                            <li class="divider"></li>
                                            <li><a href="#">Separated link</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div id="morris-area-chart"></div>
                            </div>
                            <!-- /.panel-body -->
                        </div>
						
                        <!-- /.panel ---------------CHART222222222222222-------------------------->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-bar-chart-o fa-fw"></i> Bar Chart Example
                                <div class="pull-right">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default btn-xs dropdown-toggle"
                                                data-toggle="dropdown">
                                            Actions
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu pull-right" role="menu">
                                            <li><a href="#">Action</a>
                                            </li>
                                            <li><a href="#">Another action</a>
                                            </li>
                                            <li><a href="#">Something else here</a>
                                            </li>
                                            <li class="divider"></li>
                                            <li><a href="#">Separated link</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
							
							
                            <!-- /.panel-heading --------TABLE FOR CHART22222-------------------------------------------->
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-8">
                                        <div class="table-responsive">
                                            <table class="table table-bordered table-hover table-striped">
                                                <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Date</th>
                                                    <th>Time</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tr>
                                                    <td>3326</td>
                                                    <td>10/21/2013</td>
                                                    <td>3:29 PM</td>
                                                </tr>
                                                <tr>
                                                    <td>3325</td>
                                                    <td>10/21/2013</td>
                                                    <td>3:20 PM</td>
                                                </tr>
                                                <tr>
                                                    <td>3324</td>
                                                    <td>10/21/2013</td>
                                                    <td>3:03 PM</td>
                                                </tr>
                                                <tr>
                                                    <td>3323</td>
                                                    <td>10/21/2013</td>
                                                    <td>3:00 PM</td>
                                                </tr>
                                                <tr>
                                                    <td>3322</td>
                                                    <td>10/21/2013</td>
                                                    <td>2:49 PM</td>
                                                </tr>
                                                <tr>
                                                    <td>3321</td>
                                                    <td>10/21/2013</td>
                                                    <td>2:23 PM</td>
                                                </tr>
                                                <tr>
                                                    <td>3320</td>
                                                    <td>10/21/2013</td>
                                                    <td>2:15 PM</td>
                                                </tr>
                                                <tr>
                                                    <td>3319</td>
                                                    <td>10/21/2013</td>
                                                    <td>2:13 PM</td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /.table-responsive -->
                                    </div>
                                    <!-- /.col-lg-4 (nested) -->
                                    <div class="col-lg-8">
                                        <div id="morris-bar-chart"></div>
                                    </div>
                                    <!-- /.col-lg-8 (nested) -->
                                </div>
                                <!-- /.row -->
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                       
                    </div>
                    <!-- /.col-lg-8 -->
                    <div class="col-lg-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-bell fa-fw"></i> Notifications Panel
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="list-group">
                                
                                	<%
                        
                        SenseNotificationBeanLocal senseNotificationBeanLocal = new SenseNotificationBean();
                        SenseNotificationLogicLocal senseNotificationLogicLocal = new SenseNotificationBean();
                        for(SenseNotification senseNotification : senseNotificationBeanLocal.getAllSenseNotifications()) {
                
                		%>
                			<a href="#" class="list-group-item">
                                        <i class="fa fa-comment fa-fw"></i> <%out.print(senseNotification.getSenseNotificationTitle()); %>
                                            <span class="pull-right text-muted small"><em><%out.print(senseNotificationLogicLocal.getSenseNotificationInterval(senseNotification)); %></em>
                                            </span>
                                    </a>
                           
                            
                        <%
                        }
                        %>
                                    
                                    
                                </div>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                       
                 
				 
                        <!-- /.panel .chat-panel -->
                    </div>
                    <!-- /.col-lg-4 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /#page-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- jQuery -->
        <script src="dashboard/js/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="dashboard/js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="dashboard/js/metisMenu.min.js"></script>

        <!-- Morris Charts JavaScript -->
        <script src="dashboard/js/raphael.min.js"></script>
        <script src="dashboard/js/morris.min.js"></script>
        <script src="dashboard/js/morris-data.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="dashboard/js/startmin.js"></script>

    </body>
</html>
