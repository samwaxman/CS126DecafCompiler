package styles;
import org.immutables.value.Value;

@Value.Style(
        get = {"is*", "get*"},
        init = "set*",
        typeImmutable = "*",
        typeAbstract = {"Abstract*", "*IF"})
public @interface ImmutableStyle {
}