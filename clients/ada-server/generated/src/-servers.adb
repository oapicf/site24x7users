--  swaggy_c_example
--  Example OpenAPI specification for Swaggy C using Google Search
--  ------------ EDIT NOTE ------------
--  This file was generated with openapi-generator.  You can modify it to implement
--  the server.  After you modify this file, you should add the following line
--  to the .openapi-generator-ignore file:
--
--  src/-servers.adb
--
--  Then, you can drop this edit note comment.
--  ------------ EDIT NOTE ------------
package body .Servers is


   --  Search with a query
   overriding
   procedure Search
      (Server : in out Server_Type;
       Q : in Swagger.UString;
       Result  : out Swagger.UString;
       Context : in out Swagger.Servers.Context_Type) is
   begin
      null;
   end Search;

end .Servers;
