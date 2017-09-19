<%@page pageEncoding="utf-8"
	contentType="text/html"
	import="java.util.*,java.text.*"%>
<!doctype html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0m,minimnm-scale=1.0,maximum-scale=1.0, user-scalable=no">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" >
		<meta name="renderer" content="webkit" />
		<title>TDHMonitor</title>
		<!--base href="/"-->
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<link href="image/favicon.ico" type="image/x-icon" rel="icon"/>
		<link rel="icon" type="image/x-icon" href="favicon.ico">
		<link href="assets/bootstrap-v3.3.7/bootstrap.min.css" rel="stylesheet">
		<link href="assets/font-awesome.min.css" rel="stylesheet">
		<link href="assets/echarts.min.js" rel="stylesheet">
		<link rel="stylesheet" href="styles/styles.9c994302c652ac0d1975.bundle.css"></link>
		<style type="text/css">
		.main-nav[_ngcontent-ylp-15]{
		background:#3366Cc;
		height:50px;
		padding:0;
		box-shadow:0 2px 5px 0 rgba(0,0,0,0.24)
		}
		.navbar-toggle[_ngcontent-ylp-15]   .icon-bar[_ngcontent-ylp-15]{
		background-color:#fff;
		}
		.nav[_ngcontent-ylp-15] > li[_ngcontent-ylp-15] > a[_ngcontent-ylp-15]{
		color:#fff;
		}
		.nav[_ngcontent-ylp-15] > li.active[_ngcontent-ylp-15],
		.nav[_ngcontent-ylp-15] > li[_ngcontent-ylp-15] > a[_ngcontent-ylp-15]:hover,
		.nav[_ngcontent-ylp-15] > li[_ngcontent-ylp-15] > a[_ngcontent-ylp-15]:focus,
		.nav[_ngcontent-ylp-15]   .open[_ngcontent-ylp-15] > a[_ngcontent-ylp-15],
		.nav[_ngcontent-ylp-15]   .open[_ngcontent-ylp-15] > a[_ngcontent-ylp-15]:hover,
		.nav[_ngcontent-ylp-15]   .open[_ngcontent-ylp-15] > a[_ngcontent-ylp-15]:focus{
		color:#fff;
		background-color:#777;
		}
		.navbar-brand-my[_ngcontent-ylp-15]{
		color:#fff
		}
		.logo-img[_ngcontent-ylp-15]{
		width:100%;
		height:100%
		}
		.main-container[_ngcontent-ylp-15]{
		padding-top:80px;
		min-height:800px;
		}
		.footer[_ngcontent-ylp-15]{
		text-align:left;
		padding:40px 48px;
		background:#263238;
		color:#fff;
		position:absolute;
		left:0;
		right:0;
		bottom:0;
		}
		</style>
		<style>
		.post-list-container[_ngcontent-ylp-27] > form[_ngcontent-ylp-27]{
		margin-bottom:15px;
		}
		.post-list-container[_ngcontent-ylp-27]   .post-list-container[_ngcontent-ylp-27]{
		padding-bottom:20px;
		margin-bottom:30px;
		border-bottom:1px dashed #d9d9d9;
		}
		</style>
	</head>
	<body>
		<app-root _ngcontent-ylp-15 ng-version="4.0.0-beta.3">
		<div _ngcontent-ylp-15 class="navbar navbar-fixed-top main-nav" role="navigation">
			<div _ngcontent-ylp-15 class="container">
				<div _ngcontent-ylp-15 class="navbar-header">
					<button _ngcontent-ylp-15 class="navbar-toggle" data-target=".navbar-responsive-collapse" data-toggle="collapse" type="button">
						<span _ngcontent-ylp-15 class="sr-only">Toggle Navigation</span>
						<span _ngcontent-ylp-15 class="icon-bar"></span>
						<span _ngcontent-ylp-15 class="icon-bar"></span>
						<span _ngcontent-ylp-15 class="icon-bar"></span>
					</button>
					<a _ngcontent-ylp-15 class="navbar-brand navbar-brand-my" routerlink="1" href="1.html">TDH-Monitor</a>
				</div>
				<div _ngcontent-ylp-15 aria-expanded="false" class="collapse navbar-collapse navbar-responsive-collapse">
					<ul _ngcontent-ylp-15 class="nav navbar-nav">
						<li _ngcontent-ylp-15 class="dropdown" routerlinkactive="active">
							<a _ngcontent-ylp-15 routerlink="sqlInfo" href="sqlInfo.html">动态监控</a>
						</li>
						<li _ngcontent-ylp-15 class="dropdown">
							<a _ngcontent-ylp-15 class="dropdown-toggle" data-toggle="dropdown" routerlink="userInfo" href="userInfo.html">集群信息</a>
						</li>
				</div>
			</div>
		</div>
		<div _ngcontent-ylp-15 class="container main-container">
		<router-outlet _ngcontent-ylp-15></router-outlet>
		<app-home _ngcontent-ylp-23="">
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
					<router-outlet _ngcontent-ylp-23></router-outlet>
					<app-postlist _ngcontent-ylp-27="">
						<div _ngcontent-ylp-27 class="post-list-container">
							<form _ngcontent-ylp-27 class="form-vertical ng-valid ng-pristine ng-touched" novalidate role="form">
								<div _ngcontent-ylp-27 class="row">
									<div _ngcontent-ylp-27 class="col-sm-5">
										<div _ngcontent-ylp-27 class="input-group">
										<input _ngcontent-ylp-27 class="form-control ng-pristine ng-valid ng-touched" id="search_cluster_test" name="serch_cluster_test" placeholder="输入IP/Name查询" type="text">
											<span _ngcontent-ylp-27 class="input-group-btn">
											<button _ngcontent-ylp-27 class="btn btn-default" type="button">
											搜索
										</span>
										</div>
									</div>
									<div _ngcontent-ylp-27 class="col-sm-5">
										<div _ngcontent-ylp-27 class="input-group">
										<input _ngcontent-ylp-27 class="form-control ng-pristine ng-valid ng-touched" id="search_cluster_test" name="serch_cluster_test" placeholder="输入积压量" type="text">
										<span _ngcontent-ylp-27 class="input-group-btn">
											<button _ngcontent-ylp-27 class="btn btn-default" type="button">
											搜索
										</span>
										</div>
									</div>
									<div _ngcontent-ylp-27 class="col-sm-2">
										<div _ngcontent-ylp-27 class="input-group">
											<label _ngcontent-ylp-27>
											<input _ngcontent-ylp-27 type="checkbox">
											Warn日志
											</label>
										</div>
									</div>
									<div _ngcontent-ylp-27 class="col-sm-2">
										<div _ngcontent-ylp-27 class="input-group">
											<label _ngcontent-ylp-27>
											<input _ngcontent-ylp-27 type="checkbox">
											90天到期
											</label>
										</div>
									</div>
								</div>
							</form>
							<div _ngcontent-ylp-27>
								<h2 _ngcontent-ylp-27>正在处理中...</h2>
							</div>
							<div _ngcontent-ylp-27 class="row">
								<div _ngcontent-ylp-27 class="col-sm-12">
									<pagination  _ngcontent-ylp-27 class="pagination-sm ng-untouched ng-valid ng-dirty">
									<ul class="pagination pagination-sm">
										<li class="pagination-first page-item disabled">
											<a class="page-link" href>首页</a>
										</li>
										<li class="pagination-prev page-item disabled">
											<a class="page-link" href>上一页</a>
										</li>
										<li class="pagination-page page-item disabled">
											<a class="page-link" href>1</a>
										</li>
										<li class="pagination-next page-item disabled">
											<a class="page-link" href>下一页</a>
										</li>
										<li class="pagination-last page-item disabled">
											<a class="page-link" href>末页</a>
										</li>
										</li>
									</ul>
									</pagination>
								</div>
							</div>
						</div>
						</app-postlist>
					</div>
						<div _ngcontent-ylp-23 class="col-sm-3">
							<app-social-channel _ngcontent-ylp-23 _ngcontent-ylp-17>
							<div _ngcontent-ylp-17 class="social-channel-container">
								<div _ngcontent-ylp-17 class="panel panel-default">
									<div _ngcontent-ylp-17 class="panel-heading">
										<h3 _ngcontent-ylp-17 class="panel-title">星环科技（外网）</h3>
									</div>
									<div _ngcontent-ylp-17 class="list-group">
										<a _ngcontent-ylp-17 class="list-group-item" href="http://transwarp.io" target="_blank">
											<i _ngcontent-ylp-17 aria-hidden="true" class="fa"></i>
											官方地址
										</a>
										<a _ngcontent-ylp-17 class="list-group-item" href="http://support.transwarp.cn" target="_blank">
											<i _ngcontent-ylp-17 aria-hidden="true" class="fa"></i>
											技术论坛
											
										</a>
										<a _ngcontent-ylp-17 class="list-group-item" href="http://docs.transwarp.cn" target="_blank">
											<i _ngcontent-ylp-17 aria-hidden="true" class="fa"></i>
											产品手册
											
										</a>
									</div>
								</div>
							</div>
							</app-social-channel>
								<app-social-channel _ngcontent-ylp-23 _ngcontent-ylp-19>
									<div _ngcontent-ylp-19 class="online-contact-container">
										<div _ngcontent-ylp-19 class="panel panel-default">
											<div _ngcontent-ylp-19 class="panel-heading">
												<h3 _ngcontent-ylp-19 class="panel-title">值班工程师</h3>
											</div>
											<div _ngcontent-ylp-19 class="list-group">
												<a _ngcontent-ylp-19 class="list-group-item">
													<i _ngcontent-ylp-19 aria-hidden="true" class="fa fa-qq"/>XXX:XXX</i>
												</a>
											</div>
										</div>
									</div>
								</app-social-channel>
								<app-social-channel _ngcontent-ylp-23 _ngcontent-ylp-21>
									<div _ngcontent-ylp-21 class="site-stat-container">
										<div  _ngcontent-ylp-21 class="panel panel-default">
											<div _ngcontent-ylp-21 class="panel-heading">
												<h3 _ngcontent-ylp-21 class="panel-title" id="time1">1111</h3>
											</div>
										</div>
									</div>
								</app-social-channel>
						</div>
				</div>
			</div>
			</app-home>
		</div>
		<div _ngcontent-ylp-15 class="footer bs-footer">
			<div _ngcontent-ylp-15 class="container">
				<div _ngcontent-ylp-15 class="row">
					<p _ngcontent-ylp-15>
									Powered by 
					<a _ngcontent-ylp-15 href="http://transwarp.io/" target="_blank">星环科技</a>
					</p>
				</div>
			</div>
		</div>
		</app-root>
		<script type="text/javascript" charset="utf-8" async="" src="scripts/time.js"></script>
	</body>
</html>