### HikariCP_MySQL ###

It's an example about how to use HikariCP/MySQL/Tomcat.
* HikariCP/MySQL/Tomcat.
* JSP
* HttpServlet
 
### nginx configuration to support servlet streaming output ###
 
```
    upstream local_tomcat {  
        server localhost:8080;  
    } 

    server {
        listen       80;
        server_name  www.en.cc;
        set $root "C:/Users/amtf/tal";
        root $root;

        location / {
            root  $root;
            autoindex on;
            index  index.html index.htm index.php;
        }

        # use this location to support tomcat streaming output 
        location ~ \.action$ {
            proxy_pass http://local_tomcat;
            # don't buffering, push to browser whenever application return data
            proxy_buffering off;
            proxy_read_timeout 4m;
            proxy_send_timeout 4m;
        }
    }
```