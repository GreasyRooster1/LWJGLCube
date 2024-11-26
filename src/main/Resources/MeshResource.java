package main.Resources;

import main.Mesh.Mesh;
import main.Mesh.MeshLoader;
import main.Texture.Texture;
import org.joml.Vector2f;
import org.joml.Vector3f;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static main.Mesh.MeshLoader.createMesh;

public class MeshResource extends Resource {
    private Mesh mesh;
    public MeshResource(String path) {
        super(path);
    }

    @Override
    public void load() {
        ArrayList<Integer> vertexIndices = new ArrayList<>();
        ArrayList<Integer> uvIndices  = new ArrayList<>();
        ArrayList<Integer> normalIndices  = new ArrayList<>();

        ArrayList<Vector3f> vertices  = new ArrayList<>();
        ArrayList<Vector2f> uvs  = new ArrayList<>();
        ArrayList<Vector3f> normals  = new ArrayList<>();

        File myObj = new File(path);
        Scanner scanner = null;
        try {
            scanner = new Scanner(myObj);
        }catch (FileNotFoundException e) {
            System.out.println(e);
        }
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            String[] words = currentLine.split(" ");
            if(currentLine.startsWith("vt")) {
                Vector2f uv = new Vector2f();
                uv.x = Float.parseFloat(words[1]);
                uv.y = Float.parseFloat(words[2]);
                uvs.add(uv);
            }else if(currentLine.startsWith("vn")) {
                Vector3f normal = new Vector3f();
                normal.x = Float.parseFloat(words[1]);
                normal.y = Float.parseFloat(words[2]);
                normal.z = Float.parseFloat(words[3]);
                normals.add(normal);
            }else if(currentLine.startsWith("v")) {
                Vector3f vertex = new Vector3f();
                vertex.x = Float.parseFloat(words[1]);
                vertex.y = Float.parseFloat(words[2]);
                vertex.z = Float.parseFloat(words[3]);

                vertices.add(vertex);
            }else if(currentLine.startsWith("f")) {
                String[] v1 = words[1].split("/");
                String[] v2 = words[2].split("/");
                String[] v3 = words[3].split("/");
                vertexIndices.add(Integer.parseInt(v1[0])-1);
                vertexIndices.add(Integer.parseInt(v2[0])-1);
                vertexIndices.add(Integer.parseInt(v3[0])-1);

                uvIndices.add(Integer.parseInt(v1[1])-1);
                uvIndices.add(Integer.parseInt(v2[1])-1);
                uvIndices.add(Integer.parseInt(v3[1])-1);

                normalIndices.add(Integer.parseInt(v1[2])-1);
                normalIndices.add(Integer.parseInt(v2[2])-1);
                normalIndices.add(Integer.parseInt(v3[2])-1);
            }
        }
        float[] outUv = new float[uvIndices.size()*2];
        int c =0;
        for (int i : uvIndices) {
            outUv[c] = uvs.get(i).x;
            outUv[c+1] = uvs.get(i).y;
            c+=2;
        }

        float[] outVertices = new float[vertices.size()*3];
        int c1 = 0;
        for (Vector3f vertex : vertices) {
            outVertices[c1]=vertex.x;
            outVertices[c1+1]=vertex.y;
            outVertices[c1+2]=vertex.z;
            c1+=3;
        }

        int[] outIndices = new int[vertexIndices.size()];
        int c2 = 0;
        for (int ind : vertexIndices) {
            outIndices[c2]=ind;
            c2++;
        }

        mesh = createMesh(outVertices,outUv,outIndices);

    }

    @Override
    public Mesh get() {
        return mesh;
    }
}
