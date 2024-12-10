package main.Shaders;

public class SkyBoxShader extends ProjectionShaderProgram {
    public SkyBoxShader() {
        super("resources/shaders/skybox.vert","resources/shaders/skybox.frag");
    }

    @Override
    protected void bindAttributes() {
        defaultBinds();
    }

}
