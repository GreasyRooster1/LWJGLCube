package main.Shaders;

public class SkyBoxShader extends ProjectionShaderProgram {
    public SkyBoxShader() {
        super("resources/shaders/normal.frag");
    }

    @Override
    protected void bindAttributes() {
        defaultBinds();
    }

}
