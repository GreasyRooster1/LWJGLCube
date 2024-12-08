package main.Shaders;

public class TextureShader extends ProjectionShaderProgram {
    public TextureShader() {
        super("resources/shaders/normal.frag");
    }

    @Override
    protected void bindAttributes() {
        defaultBinds();
    }

}
