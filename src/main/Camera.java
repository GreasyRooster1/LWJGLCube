package main;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

public class Camera {
    public Vector3f position;
    public Vector3f direction;
    public Vector3f target;
    public Vector3f cameraRight;
    public Vector3f cameraUp;

    Camera(Vector3f position,Vector3f target) {
        this.position = position;
        this.target = target;
        direction = position.sub(target).normalize();
        Vector3f up = new Vector3f(0f,1f,0f);
        cameraRight = up.cross(direction).normalize();
        cameraUp =direction.cross(cameraRight).normalize();
    }

    public Matrix4f getView() {
        Matrix4f view = new Matrix4f();
        return view;
    }

}
