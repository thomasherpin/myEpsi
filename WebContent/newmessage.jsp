<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Message</title>
</head>
<body>
<body>
    <div id="login-overlay" class="modal-dialog">
      <div class="modal-content">
          <div class="modal-header">
              <h4 class="modal-title" id="myModalLabel"><b>Créer un nouveau message</b></h4>
          </div>
          <div class="modal-body">
              <div class="row">
                  <div class="col-xs">
                      <div class="well">
                          <form id="loginForm" method="GET">
                              <div class="form-group">
                                  <label for="mail" class="control-label">Titre du message</label>
                                  <input type="text" class="form-control" name="title" value="" required="" title="Please enter your title" placeholder="Titre, 140 characters max...">
                                  <span class="help-block"></span>
                              </div>
                              <div class="form-group">
                                  <label for="content" class="control-label">Contenu</label>
                                  <textarea name="content" class="form-control" placeholder="You can put your message here... " required=""></textarea>
                                  <span class="help-block"></span>
                              </div>
                              <div id="loginErrorMsg" class="alert alert-error hide">Wrong username or password</div>
                              <button type="submit" value="login" name="submit" class="btn btn-success btn-block">Ajouter</button>
                              <button type="submit" value="login" name="submit" class="btn btn-danger btn-block">Annuler</button>
                          </form>
                      </div>
                  </div>
              </div>
          </div>
      </div>

  </div>

</body>
</html>