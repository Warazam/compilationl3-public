/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AAppelfct extends PAppelfct
{
    private TIdentif _identif_;
    private TParentheseOuvrante _parentheseOuvrante_;
    private PListeexp _listeexp_;
    private TParentheseFermante _parentheseFermante_;

    public AAppelfct()
    {
        // Constructor
    }

    public AAppelfct(
        @SuppressWarnings("hiding") TIdentif _identif_,
        @SuppressWarnings("hiding") TParentheseOuvrante _parentheseOuvrante_,
        @SuppressWarnings("hiding") PListeexp _listeexp_,
        @SuppressWarnings("hiding") TParentheseFermante _parentheseFermante_)
    {
        // Constructor
        setIdentif(_identif_);

        setParentheseOuvrante(_parentheseOuvrante_);

        setListeexp(_listeexp_);

        setParentheseFermante(_parentheseFermante_);

    }

    @Override
    public Object clone()
    {
        return new AAppelfct(
            cloneNode(this._identif_),
            cloneNode(this._parentheseOuvrante_),
            cloneNode(this._listeexp_),
            cloneNode(this._parentheseFermante_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAppelfct(this);
    }

    public TIdentif getIdentif()
    {
        return this._identif_;
    }

    public void setIdentif(TIdentif node)
    {
        if(this._identif_ != null)
        {
            this._identif_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identif_ = node;
    }

    public TParentheseOuvrante getParentheseOuvrante()
    {
        return this._parentheseOuvrante_;
    }

    public void setParentheseOuvrante(TParentheseOuvrante node)
    {
        if(this._parentheseOuvrante_ != null)
        {
            this._parentheseOuvrante_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._parentheseOuvrante_ = node;
    }

    public PListeexp getListeexp()
    {
        return this._listeexp_;
    }

    public void setListeexp(PListeexp node)
    {
        if(this._listeexp_ != null)
        {
            this._listeexp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._listeexp_ = node;
    }

    public TParentheseFermante getParentheseFermante()
    {
        return this._parentheseFermante_;
    }

    public void setParentheseFermante(TParentheseFermante node)
    {
        if(this._parentheseFermante_ != null)
        {
            this._parentheseFermante_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._parentheseFermante_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._identif_)
            + toString(this._parentheseOuvrante_)
            + toString(this._listeexp_)
            + toString(this._parentheseFermante_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._identif_ == child)
        {
            this._identif_ = null;
            return;
        }

        if(this._parentheseOuvrante_ == child)
        {
            this._parentheseOuvrante_ = null;
            return;
        }

        if(this._listeexp_ == child)
        {
            this._listeexp_ = null;
            return;
        }

        if(this._parentheseFermante_ == child)
        {
            this._parentheseFermante_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._identif_ == oldChild)
        {
            setIdentif((TIdentif) newChild);
            return;
        }

        if(this._parentheseOuvrante_ == oldChild)
        {
            setParentheseOuvrante((TParentheseOuvrante) newChild);
            return;
        }

        if(this._listeexp_ == oldChild)
        {
            setListeexp((PListeexp) newChild);
            return;
        }

        if(this._parentheseFermante_ == oldChild)
        {
            setParentheseFermante((TParentheseFermante) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
