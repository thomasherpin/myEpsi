<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
    <div id="login-overlay" class="modal-dialog">
      <div class="modal-content">
          <div class="modal-header">
              <h4 class="modal-title" id="myModalLabel"><b>Bienvenue sur myEpsi</b></h4>
          </div>
          <div class="modal-body">
              <div class="row">
                  <div class="col-xs-6">
                      <div class="well">
                          <form id="loginForm" method="GET">
                              <div class="form-group">
                                  <label for="mail" class="control-label">Mail</label>
                                  <input type="text" class="form-control" name="mail" value="" required="" title="Please enter your mail" placeholder="mail">
                                  <span class="help-block"></span>
                              </div>
                              <div class="form-group">
                                  <label for="password" class="control-label">Password</label>
                                  <input type="password" class="form-control" name="password" placeholder="password" value="" required="" title="Please enter your password">
                                  <span class="help-block"></span>
                              </div>
                              <div id="loginErrorMsg" class="alert alert-error hide">Wrong username or password</div>
                              <button type="submit" value="login" name="submit" class="btn btn-success btn-block">Login</button>
                          </form>
                      </div>
                  </div>
                  <div class="col-xs-6">
                      <div class="well">
                          <form id="registerForm" method="GET">
                              <div class="form-group">
                                  <label for="mail" class="control-label">Mail</label>
                                  <input type="text" class="form-control" name="mail" value="" required="" title="Please enter your mail" placeholder="mail@mail.xx">
                                  <span class="help-block"></span>
                              </div>
                              <div class="form-group">
                                  <label for="password" class="control-label">Password</label>
                                  <input type="password" class="form-control" name="password" placeholder="password" value="" required="" title="Please enter your password">
                                  <span class="help-block"></span>
                              </div>
                              <div class="form-group">
                                  <label for="confirmpassword" class="control-label">Confirm your password</label>
                                  <input type="password" class="form-control" name="Confirmpassword" placeholder="Confirm password" value="" required="" title="Please confirm by enter your password">
                                  <span class="help-block"></span>
                              </div>
                              <div id="registerErrorMsg" class="alert alert-error hide">Mail already exist</div>
                              <button type="submit" value="login" name="submit" class="btn btn-success btn-block">Register</button>
                          </form>
                      </div>
                  </div>
              </div>
          </div>
      </div>

  </div>
<script type="text/javascript">

</script>

</html>
