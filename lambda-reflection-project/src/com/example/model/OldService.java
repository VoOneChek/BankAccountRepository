package com.example.model;

import com.example.annotation.DeprecatedEx;

@DeprecatedEx(message = "Use NewService")
public class OldService {

    @DeprecatedEx(message = "Use newMethod")
    public void oldMethod() {}
}