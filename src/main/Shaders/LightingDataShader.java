package main.Shaders;

public class LightingDataShader extends ProjectionShader {
    public LightingDataShader() {
        super("resources/shaders/texture.frag");
    }

    @Override
    protected void bindAttributes() {
        defaultBinds();
    }

}
