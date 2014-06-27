package search.util;

import java.util.NoSuchElementException;

/**
 * Diese Realisierung von {@code Queue} verfaehrt nach dem LIFO-Prinzip. Es
 * handelt sich also um dass, wass man allgemein als Stack bezeichnet.
 * 
 * @author Erich Ehses.
 */
public final class LIFOQueue<T> implements IQueue<T> {
	private static class Link<T> {
		Link(T value, Link<T> next) {
			this.value = value;
			this.next = next;
		}

		T value;
		Link<T> next;
	}

	Link<T> first = null;

	/*
	 * Klasseninvariante: bei leerer Liste ist first = null sonst enthaelt first
	 * die Referenz auf den 1. Listenknoten (Link). Links enthalten einen Wert
	 * (value = Nutzinformation) und die Referenz auf den nachfolgenden Knoten
	 * (next). Das next-Feld des letzten Knotens ist null.
	 * 
	 * Hinweis: Beachten Sie auch die Kommentare in IQueue!
	 */

	@Override
	public void put(T value) {
		Link<T> meinLink = new Link(value, null);
		if (this.isEmpty())
			first = meinLink;
		else {
			Link<T> p = first;
			while (p.next != null) {
				p = p.next;
			}
			p.next = meinLink;
		}
	}

	@Override
	public T get() {
		if (this.isEmpty())
			throw new NoSuchElementException("Queue is empty!");
		T result;
		if (first.next == null) {
			result = first.value;
			this.clear();
		} else {
			Link<T> p = first;
			while (p.next.next != null) {
				p = p.next;
			}
			result = p.next.value;
			p.next = null;
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public void clear() {
		first = null;
	}
}
