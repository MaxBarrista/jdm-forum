package com.barrista.jdm.forum.domain;

import com.fasterxml.jackson.annotation.JsonView;

public final class Views
{
    public interface Id {}

    public interface IdName extends Id {}

    public interface FullMessage extends Id {}
}
