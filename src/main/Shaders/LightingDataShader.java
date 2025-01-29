package main.Shaders;

public class LightingDataShader extends ProjectionShader {
    public LightingDataShader(String fragPath) {
        super("resources/shaders/lighting/lighting.vert",fragPath);
    }

    @Override
    protected void bindAttributes() {
        defaultBinds();
    }

}
