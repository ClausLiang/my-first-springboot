# my-first-springboot

这是我使用 IntelliJ IDEA 创建的 Spring Boot 学习项目，用来边实践边记录 Spring Boot 的学习过程。项目目前处于起步阶段，后续会随着学习逐步增加示例、测试和笔记。

详细的学习过程记录在博客：[Spring Boot 学习记录](https://liangyonggang.com/myblog/2026/11/08/springboot/)。

## 当前进度

- 已创建 Spring Boot 项目和应用入口 `MyFirstSpringbootApplication`。
- 已引入 Spring Web MVC 及其测试依赖。
- 已有一个用于加载应用上下文的基础测试 `MyFirstSpringbootApplicationTests`。
- 已实现第一个接口：访问 `http://localhost:8080/hello` 返回 `hello world`；加上 `?name=Claus` 返回 `hello Claus`。
- 已使用 `@Value` 读取 `application.properties` 中的 `email.user` 和 `email.host`，并在启动时打印到控制台。
- 已添加 GET `/getProperties`，在 Controller 中读取并以 JSON 返回这两个配置。

## 开发环境

| 项目 | 版本或说明 |
| --- | --- |
| JDK | 17 |
| Spring Boot | 4.1.2 |
| Maven | 3.10.0（本机安装并在 IDEA 中配置；Maven Wrapper 也指定此版本） |
| IDE | IntelliJ IDEA |

实际依赖和版本以 [`pom.xml`](pom.xml) 为准。

## 运行与测试

在 IDEA 中打开项目，等待 Maven 导入完成，然后运行 `src/main/java/com/claus/myfirstspringboot/MyFirstSpringbootApplication.java` 中的 `main` 方法。

应用启动后，在浏览器打开 `http://localhost:8080/hello`，或用 `http://localhost:8080/hello?name=Claus` 传入名字。`@RestController` 表示该类处理 Web 请求并直接返回响应内容；`@GetMapping("/hello")` 将 GET 请求映射到 `hello()` 方法；`@RequestParam` 读取 URL 中的 `name` 参数，未提供时使用默认值 `world`。

访问 `http://localhost:8080/getProperties` 可看到 `email.user` 和 `email.host` 的 JSON 响应。这两个值只是学习示例；不要把密码、令牌等敏感配置通过接口返回。

也可以在项目根目录使用本机安装的 Maven：

```powershell
mvn spring-boot:run
mvn test
```

如果使用项目自带的 Maven Wrapper，Windows 下将 `mvn` 换成 `.\mvnw.cmd`；首次运行可能需要下载 Maven。

## 项目结构

```text
src/
├─ main/
│  ├─ java/com/claus/myfirstspringboot/  # 应用代码
│  └─ resources/                          # 应用配置
└─ test/java/com/claus/myfirstspringboot/ # 测试代码
```

## 学习记录

| 阶段 | 学习内容 | 实践结果 |
| --- | --- | --- |
| 项目初始化 | 使用 IDEA 创建 Spring Boot 项目，认识入口类、`pom.xml` 和目录结构 | 已建立基础工程，准备开始编写示例 |
| 第一个接口 | 认识 `@RestController`、`@GetMapping` 和 HTTP GET 请求 | `/hello` 返回 `hello world`，并用测试验证响应 |
| 请求参数 | 使用 `@RequestParam` 接收 URL 中的 `name` 参数并设置默认值 | `/hello?name=Claus` 返回 `hello Claus`；不传参数仍返回 `hello world` |
| 读取配置 | 使用 `@Value` 注入 `application.properties` 中的值，使用 `@PostConstruct` 在组件初始化后打印 | 启动时在控制台看到 `email.user` 和 `email.host` |
| Controller 读取配置 | 在 `HelloController` 中使用 `@Value`，通过 GET 接口返回配置 | `/getProperties` 返回包含两个配置的 JSON |

后续每完成一个学习主题，就在这里补充学习内容、对应代码和遇到的问题；具体代码以仓库中的提交记录为准。
