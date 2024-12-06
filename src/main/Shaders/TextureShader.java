package main.Shaders;

public class TextureShader extends ProjectionShaderProgram {
    public TextureShader() {
        super("resources/shaders/texture.frag");
    }

    @Override
    protected void bindAttributes() {
        defaultBinds();
    }

}
