package name.lemerdy.eric.Application.UseCases;

import name.lemerdy.eric.Application.Boundaries.Register.IUseCase;
import name.lemerdy.eric.Application.Boundaries.Register.RegisterInput;

/**
 * Register <see href="https://github.com/ivanpaulovich/clean-architecture-manga/wiki/Domain-Driven-Design-Patterns#use-case">Use Case Domain-Driven Design Pattern</see>.
 */
public final class Register implements IUseCase {

    /**
     * Executes the Use Case.
     *
     * @param input Input Message.
     */
    @Override
    public void Execute(RegisterInput input) {
        throw new UnsupportedOperationException();
    }
}
