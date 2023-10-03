package com.dcs.user.registration.converter;
/*
 * Copyright (c) 2023 Seiko Epson. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

public interface Converter<S,T>
{
	T convert(S source);

	default List<T> convertAll(final List<S> sourceList)
	{
		List<T> targets = new ArrayList<>();
		sourceList.forEach(source->targets.add(convert(source)));
		return targets;
	}
}
