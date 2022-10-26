import org.gradle.api.artifacts.dsl.DependencyHandler as DependencyScope

private const val Api = "api"
private const val Implementation = "implementation"
private const val TestImplementation = "testImplementation"

fun DependencyScope.implementations(
    vararg paths: Any,
) {
    delegate(
        method = Implementation,
        paths = paths,
    )
}

fun DependencyScope.testImplementations(
    vararg paths: Any,
) {
    delegate(
        method = TestImplementation,
        paths = paths,
    )
}

fun DependencyScope.apis(
    vararg paths: Any,
) {
    delegate(
        method = Api,
        paths = paths,
    )
}

private fun DependencyScope.delegate(
    method: String,
    vararg paths: Any,
) {
    paths.forEach { path ->
        add(method, path)
    }
}
