# 项目协作规范

本文件适用于整个 `my-first-springboot` 仓库。修改项目时，以现有代码和 `pom.xml` 为准；若项目配置发生变化，同步更新本文件。

## 项目概况

- 使用 Java 17、Spring Boot 4.1.2 和 Maven。
- Maven Wrapper 指定 Maven 3.10.0；开发者也可以使用本机安装并在 IntelliJ IDEA 中配置的 Maven。
- 主包名为 `com.claus.myfirstspringboot`。应用入口是 `MyFirstSpringbootApplication`。
- 生产代码放在 `src/main/java`，配置放在 `src/main/resources`，测试放在 `src/test/java`。

## 修改约定

- 保持改动聚焦当前需求，沿用现有包结构和 Java 代码的 4 空格缩进。
- 新增依赖或调整 Java、Spring Boot 版本时，修改 `pom.xml` 并说明原因。
- 新增功能或修复缺陷时，补充能验证其行为的测试；测试与对应代码放在相同的包结构下。
- 不提交 `target/`、`.idea/` 等生成文件或本地 IDE 配置；遵循 `.gitignore`。
- 不把密码、令牌等敏感信息写入源码、配置或提交记录。

## 验证与提交

- 优先用本机已安装的 Maven 运行 `mvn test`；也可以在 IntelliJ IDEA 中使用已配置的 Maven 运行测试。
- `mvnw`（macOS/Linux）和 `mvnw.cmd`（Windows）可用于按项目指定版本运行 Maven；首次使用可能下载 Maven。
- 提交前检查 `git status` 和改动内容。若测试未运行或未通过，在交付说明中明确写出。

## Git 提交信息

- 格式：`类型(范围): 中文说明`。暂时没有明确范围时保留空括号，例如 `feat(): 添加用户登录接口`。
- 常用类型：`feat`（新功能）、`fix`（修复问题）、`docs`（文档）、`refactor`（重构）、`test`（测试）、`chore`（构建或维护）。
- 范围可写模块名，例如 `fix(user): 修复用户信息查询错误`。说明用简洁中文描述本次改动，不写笼统的“修改代码”。
