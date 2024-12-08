package main.Resources;

import main.Mesh.Mesh;
import main.Mesh.MeshLoader;
import org.joml.Vector2f;
import org.joml.Vector3f;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static main.Mesh.MeshBuilder.createMesh;

public class MeshResource extends Resource {
    private Mesh mesh;
    public MeshResource(String path) {
        super(path);
    }

    @Override
    public void load() {
        MeshLoader loader = new MeshLoader(path);
        mesh = loader.load();
    }

    @Override
    public Mesh get() {
        return mesh;
    }
}
