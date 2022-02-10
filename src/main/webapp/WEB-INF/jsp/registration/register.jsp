<jsp:include page="../include/header.jsp" />


 <form method = "GET"  action = "/registration-url-path/registerSubmit" >

    <table cellpadding ="5">
      <tr>
         <td> Email </td>
         <td><input type = "text", name = "email"><td> </br>
      </tr>
      <tr>
         <td> firstName </td>
         <td><input type = "text", name = "firstName"> <td> </br>
      </tr>
      <tr>
        <td> lastName </td>
        <td><input type = "text", name = "lastName"> <td> </br>
      </tr>
      <tr>
        <td> password </td>
        <td><input type = "password", name = "password"> <td> </br>
      </tr>
      <tr>
        <td> confirmPassword</td>
        <td><input type = "password", name = "confirmPassword"> <td> </br>
      </tr>
      <tr>
         <td> Username </td>
               <td><input type = "text", name = "username"> <td> </br>
        </tr>


    </table>

        <button type = "submit"> Submit </button> <br/>
 </form>


<jsp:include page="../include/footer.jsp" />
