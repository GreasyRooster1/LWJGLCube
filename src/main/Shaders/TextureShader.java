package main.Shaders;

public class TextureShader extends ProjectionShaderProgram {
    public TextureShader() {
        super("resources/shaders/uv.frag");
    }

    @Override
    protected void bindAttributes() {
        defaultBinds();
    }

}
