## 单点登陆(SSO)

SSO(Single Sign On)，单点登录，简单来说就是在一个具有多个子系统的系统中，只用登录一个子系统，然后访问其他子系统时不需要再次登录，即“一次登录，多处访问”，能够有效的提升用户体验。

### 1 Cookie实现Session共享

#### 1.1 基本原理

单点登录的大致流程如下（基于cookie）：

1.用户首次访问A系统，A系统发现用户未登录，则重定向到SSO认证中心并携带请求url与客户端id，进行登录验证；

2.用户在SSO认证中心进行用户名和密码验证登录，登录成功后，服务器生成一个ticket，然后重定向到系统A的源url并将该ticket追加到url参数。

3.系统A获取到url参数中的ticket，向SSO发起ticket较验，较验成功，则系统A放行，并将ticket存入到cookie。

4.用户访问B系统，此时B系统domain下的cookie已经携带ticket，直接向SSO发起ticket较验，较验成功，则放行，并将ticket存入cookie(更新ticket过期时间)

5.用户登出时，移除当前domain下的cookie。

![img](https://images.gitee.com/uploads/images/2019/0526/204538_51472438_1537128.png)

#### 1.2 技术实现

通过Springboot搭建后台服务并采用共享cookie实现SSO，sso-server使用redis存储用户ticket，app-a和app-b使用Spring拦截器过滤用户请求，每个请求都需要向sso-server验证ticket,若验证失败则重定向到登录(附带源url).

![img](https://images.gitee.com/uploads/images/2019/0526/204538_3d77aa5a_1537128.png)

注意：在测试过程中发现cookie写入的都是二级域名，例如a.test.com而不是test.com，这导致其他系统无法共享cookie而导致单点登录失败，解决办法是设置domain为.test.com即可



### 2 CAS框架介入

TODO

